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

import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.misc.SerializedClassifier;

public class NeuralNetwork {
	static SerializedClassifier mlp;
	static char[] nextMove = {'F','f','R','r','L','l','U','u','D','d','B','b'};

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
	}

	protected static char predictNextMove(Cube cube, String model){
		try {
			initialise(model);


			Instance inst = new DenseInstance(55);
			inst.setDataset(instances);

			inst = cube.setInstance(inst);

			double[] distrib = mlp.distributionForInstance(inst);

			double max = 0.0;
			int index = 0;
			for(int i = 0; i<distrib.length;i++){
				if(distrib[i]>max){
					index = i;
					max = distrib[i];
				}
			}

			return nextMove[index];
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return '?';

	}
	public static void main(String[] args) throws Exception{



		//		Evaluation eval = new Evaluation(instances);
		//		eval.evaluateModel(mlp, instances);
		//		System.out.println(eval.toSummaryString("\nResults\n======\n", false));

		Cube cube = new Cube();
		cube.backprimeTurn(false);

		System.out.println(predictNextMove(cube, "Model_20"));

	}
}
