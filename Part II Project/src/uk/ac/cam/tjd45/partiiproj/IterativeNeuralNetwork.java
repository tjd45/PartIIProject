package uk.ac.cam.tjd45.partiiproj;
import weka.core.Attribute;
import weka.core.Capabilities;
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
import weka.classifiers.IterativeClassifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.misc.SerializedClassifier;


import weka.classifiers.Classifier; 
import weka.core.Instances;
import weka.core.SerializationHelper;


public class IterativeNeuralNetwork {
	static MultilayerPerceptron mlp = new MultilayerPerceptron();
	
	public static void main(String[] args){

	DataSource source;
	Object o[];
	
	try {
		source = new DataSource(new FileInputStream( new File("/Users/ThomasDavidson/Documents/Cambridge/Part II Project/Machine Learning Model Results/Ten Move Tests/TenMoves.arff")));
		Instances current = source.getDataSet();

		current.setClassIndex(current.numAttributes()-1);
		
		o = SerializationHelper.readAll("/Users/ThomasDavidson/Documents/Cambridge/Part II Project/Machine Learning Model Results/Ten Move Tests/Models/model_80.model");
		
		//System.out.println(mlp.toString());
		
		mlp = (MultilayerPerceptron)o[0];
		mlp.setAutoBuild(false);
		mlp.initializeClassifier(current);
		
		
		
		Instances data = (Instances) o[1]; // is the data compatible?
		
		if (!data.equalHeaders(current))
		throw new Exception("Incompatible data!");

		
		Evaluation eval = new Evaluation(current);
		eval.evaluateModel(mlp, current);
		System.out.println(eval.toSummaryString("\nInitial Results\n======\n", false));
		
		for(int i = 0; i<10; i++){
			mlp.next();
			eval.evaluateModel(mlp, current);
			System.out.println(eval.toSummaryString("\nEpoch "+(i+1)+" Results\n======\n", false));
		}
		
		mlp.setMomentum(0.4);
		mlp.setLearningRate(0.5);
		
		for(int i = 0; i<10; i++){
			mlp.next();
			eval.evaluateModel(mlp, current);
			System.out.println(eval.toSummaryString("\nEpoch "+(i+1)+" Results\n======\n", false));
		}
//		eval.evaluateModel(mlp, current);
//		System.out.println(eval.toSummaryString("\nResults\n======\n", false));

		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}