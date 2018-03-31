package uk.ac.cam.tjd45.partiiproj;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.converters.Loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.misc.SerializedClassifier;

public class NeuralNetwork {
	static SerializedClassifier mlp;
	static char[] nextMove = {'F','f','R','r','L','l','U','u','D','d','B','b'};
	static boolean initialised = false;
	static String[] availableModels = {"Model_20","Model_40","Model_80","Model_10_10","Model_10_20"
			,"Model_10_40","Model_20_10","Model_20_20","Model_20_40"};

	static Instances instances;

	private static void initialise(String modelname) {
		mlp = new SerializedClassifier();
		mlp.setModelFile(new File("/Users/ThomasDavidson/Documents/Cambridge/Part II Project/Machine Learning Model Results/Ten Move Tests/Models/"+modelname+".model"));
		DataSource source;
		try {
			source = new DataSource(new FileInputStream( new File("/Users/ThomasDavidson/Documents/Cambridge/Part II Project/Machine Learning Model Results/Ten Move Tests/Skeleton.arff")));



			instances = source.getDataSet();

			instances.setClassIndex(instances.numAttributes()-1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialised = true;
	}

	protected static char predictNextMove(Cube cube, String model, boolean second){
		try {

			if(!initialised){
				initialise(model);
			}

			Instance inst = new DenseInstance(55);
			inst.setDataset(instances);

			inst = cube.setInstance(inst);

			double[] distrib = mlp.distributionForInstance(inst);

			double max = 0.0;
			double secmax = 0.0;

			int index = 0;
			int sindex = 0;
			for(int i = 0; i<distrib.length;i++){
				if(distrib[i]>max){
					index = i;
					max = distrib[i];
				}else if(distrib[i]>secmax){
					sindex = i;
					secmax = distrib[i];
				}
			}

			if(second)
				index = sindex;



			return nextMove[index];


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return '?';

	}

	protected static void analyse(String model, int N, int maxMoves, int backTrackIndex,int select, boolean output){
		Cube cube = new Cube();
		float[] solved = new float[10];
		initialise(model);

		for (int i = 0; i<10;i++){
			for (int j = 0; j < N; j++){

				cube = new Cube();
				String scram = cube.scramble(i+1, false);

				if(select == 1){
					Solutions.attemptNeuralSolve(cube, model, maxMoves, backTrackIndex, false);
				}else if (select ==2){
					Solutions.attemptSimpleBackNeuralSolve(cube, model, maxMoves, backTrackIndex, false);
				}else if (select ==3){
					Solutions.attemptdoubleBackNeuralSolve(cube, model, maxMoves, backTrackIndex, false);
				}else{
					Solutions.attemptSimpleNeuralSolve(cube, model, maxMoves, backTrackIndex, false);
				}

				if(cube.solved()){
					solved[i]++;
				}

			}
			System.out.println((i+1)+" move scrambles complete");
		}

		if(output){
			try {
				PrintWriter pw = new PrintWriter(new File(model+"Performance.csv"));
				StringBuilder sb = new StringBuilder();

				sb.append("X-moves,");

				for(int i = 0;i<10;i++){
					sb.append(i+1+",");
				}

				sb.append("\n");

				sb.append("Percentage Solved,");

				for(int i = 0;i<10;i++){
					sb.append(solved[i]/((float) N)*100);
					sb.append(",");
				}

				pw.write(sb.toString());
				pw.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			for(int i = 0; i < 10; i++){
				System.out.println((int)solved[i]+" "+(i+1)+" move scrambles solved: "+(solved[i]/(float) N)*100);
			}
		}


	}

	protected static void stepAnalyse(int N, int emove, boolean output){
		Cube cube = new Cube();
		String scramble = "";
		char nm;

		//int correct = 0;
		int[] correct = new int[availableModels.length];

		for(int j = 0; j<availableModels.length; j++){
			initialise(availableModels[j]);

			for(int i = 0; i<N; i++){
				cube = new Cube();

				scramble = Solutions.invert(cube.scramble(emove, false));
				nm = predictNextMove(cube, availableModels[j], false);

				if(nm==scramble.charAt(0)){
					correct[j]++;
				}
			}
		}

		if(output){
			try {
				PrintWriter pw = new PrintWriter(new File("ModelsPerformance"+emove+"Move.csv"));
				StringBuilder sb = new StringBuilder();

				sb.append("X-move,");

				sb.append(emove+",");

				sb.append("\n");

				sb.append("Percentage Correctly Predicted,");
				for(int i = 0; i <availableModels.length;i++){
					sb.append(availableModels[i]+",");
				}

				sb.append("\n");
				sb.append(",");

				for(int i = 0; i <availableModels.length;i++){
					sb.append((float)correct[i]/(float)N * 100+",");
				}

				pw.write(sb.toString());
				pw.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Percentage of "+emove+" move, first moves correctly predicted for - ");
			for(int i = 0; i<availableModels.length;i++){
				System.out.println(availableModels[i]+": "+(float)correct[i]/(float)N * 100);
			}

		}



	}
	public static void main(String[] args) throws Exception{



		//		Evaluation eval = new Evaluation(instances);
		//		eval.evaluateModel(mlp, instances);
		//		System.out.println(eval.toSummaryString("\nResults\n======\n", false));


		//		for(int i = 1; i<11;i++){
		//			stepAnalyse(10000,i,true);
		//			System.out.println(i+" move completed");
		//		}
		long startTime = System.nanoTime();
		analyse("Model_80",10000,100,1,3,false);
		long endTime = System.nanoTime();
		long duration = (endTime-startTime)/1000000000;
		System.out.println("Duration: "+duration);

		startTime = System.nanoTime();
		analyse("Model_80",10000,100,1,4,false);
		endTime = System.nanoTime();
		duration = (endTime-startTime)/1000000000;
		System.out.println("Duration: "+duration);




	}
}
