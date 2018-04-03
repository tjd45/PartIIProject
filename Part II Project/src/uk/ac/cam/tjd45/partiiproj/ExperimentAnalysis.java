package uk.ac.cam.tjd45.partiiproj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExperimentAnalysis {
	protected static String[][] Entrant = new String[20][];
	protected static String[][] Scrambles = new String[13][];
	protected static int[] numSolved = new int[10];
	protected static int[] numAttempted = new int[10];
	protected static int[] numSolvedNeural = new int[10];
	protected static int[] numAttemptedNeural = new int[10];


	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	static void readCSV(String csvFile){
		BufferedReader br = null;
		String line = "";
		int i = 0;
		try {

			br = new BufferedReader(new FileReader(csvFile+".csv"));
			br.readLine();
			br.readLine();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] Case = line.split(",");
				Entrant[i] = new String[Case.length];
				for(int j = 0; j<Case.length;j++){
					Entrant[i][j]=Case[j];
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	static void getAssociatedScrambles(String scrambleFile){
		BufferedReader br = null;
		String line = "";
		int i = 0;
		try {

			br = new BufferedReader(new FileReader(scrambleFile+".txt"));
			while ((line = br.readLine()) != null) {
				line = br.readLine();

				String[] groupedScrambles = line.split(";");

				int sIndex = 0;
				Scrambles[i]=new String[27];
				for(int j = 0; j<groupedScrambles.length;j++){
					String[] indivScrambles = groupedScrambles[j].split(",");

					for(int k = 0; k<indivScrambles.length; k++){
						Scrambles[i][k+sIndex]=indivScrambles[k];
					}
					sIndex+=3;
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	static void getOveralls(){

		for(int i = 0;i<Entrant.length;i++){
			if(Entrant[i].length>7){
				int startIndex = 6;
				for(int j = 0; j<9; j++){
					for(int k=0;k<3;k++){
						if(Entrant[i][startIndex+k].equals("y")){
							numSolved[j]++;
							numAttempted[j]++;
						}else{
							numAttempted[j]++;
						}

					}
					startIndex+=3;
				}
			}
		}
	}

	static void testNeural(String model, int maxMoves, boolean backtrackallowed){
		if(model.length()<1){
			model = Solutions.defaultModel;
		}
		Cube cube = new Cube();
		for(int i = 0; i<Scrambles.length; i++){
			for(int j = 0; j<Scrambles[i].length;j++){

				int scramIndex = Scrambles[i][j].length()-2;
				cube = new Cube();
				cube.performAlgorithm(Scrambles[i][j], false);

				if(backtrackallowed){
					Solutions.attemptdoubleBackNeuralSolve(cube, model, maxMoves, 1, false);
				}else{
					Solutions.attemptSimpleNeuralSolve(cube, model, maxMoves, 1, false);
				}

				if(cube.solved()){
					numSolvedNeural[scramIndex]++;

				}
				numAttemptedNeural[scramIndex]++;

			}
		}
	}

	public static void main(String[] args) {
		readCSV("ExperimentResults");
		getAssociatedScrambles("ControlledExperimentScrambles");
		getOveralls();
		testNeural("Model_80",100,true);



		for(int i = 0;i<9;i++){
			System.out.println((i+2)+" move scramble ");
			System.out.println("Human solved: "+numSolved[i]+": "+round(((double)numSolved[i]/(double)numAttempted[i])*100,2)+"% Neural net solved: "+numSolvedNeural[i]+": "+round(((double)numSolvedNeural[i]/(double)numAttemptedNeural[i])*100,2)+"%");
		}


	}
}
