package uk.ac.cam.tjd45.partiiproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StepAnalyser {
	private static int[][] counter = null;
	private static int[][] loopcounter = null;

	private static void printStep(int X){
		for(int i = 0;i<counter[X].length;i++){
			System.out.println("Move "+i+" used "+counter[X][i]+" times");
		}
		for(int i = 0; i < loopcounter[X].length; i++){
			System.out.println("Looped "+i+" times: "+loopcounter[X][i]);
		}
	}
	private static void printAnalysis(){

		for(int i = 0; i<counter.length;i++){
			System.out.println("Step "+i);
			System.out.println();
			printStep(i);
			System.out.println();
		}
	}

	private static void printAnalysistoFile(String file,int S){
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File(file+S+"MoveSelection.csv"));


			StringBuilder sb = new StringBuilder();

			for(int i = 0; i<counter.length;i++){
				sb.append("Step "+i+"\n");
				sb.append("Move no.:,");
				
				for(int j = 0;j<counter[i].length;j++){
					sb.append(j+",");
				}
				sb.append("\n");
				
				sb.append("Occurences:,");
				
				for(int j = 0;j<counter[i].length;j++){
					sb.append(counter[i][j]+",");
				}
				
				sb.append("\n");
				sb.append("No. of Loops:,");
				for(int j = 0;j<loopcounter[i].length;j++){
					sb.append(j+",");
				}
				sb.append("\n");
				
				sb.append("Occurrunces:,");
				for(int j = 0;j<loopcounter[i].length;j++){
					sb.append(loopcounter[i][j]+",");
				}
				
				sb.append("\n");
			}
			pw.write(sb.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void analyse(String method, int N, int S, boolean p){

		Cube cube;

		java.util.Arrays.fill(Solutions.counter1, 0);
		java.util.Arrays.fill(Solutions.counter2, 0);
		java.util.Arrays.fill(Solutions.counter3, 0);
		java.util.Arrays.fill(Solutions.counter4, 0);
		java.util.Arrays.fill(Solutions.counter5, 0);
		java.util.Arrays.fill(Solutions.counter6, 0);
		java.util.Arrays.fill(Solutions.counter7, 0);

		if(method.equals("CFOP")){
			counter = new int[7][];
			loopcounter = new int[7][];

			counter[0] = new int[Solutions.crossmoves.length];
			loopcounter[0] = new int[13];
			counter[1] = new int[Solutions.cornermoves.length];
			loopcounter[1] = new int[6];
			counter[2] = new int[Solutions.FB2lmoves.length];
			loopcounter[2] = new int[6];
			counter[3] = new int[Solutions.topCrossMoves.length];
			loopcounter[3] = new int[6];
			counter[4] = new int[Solutions.tcPermMoves.length];
			loopcounter[4] = new int[13];
			counter[5] = new int[Solutions.tcorPermMoves.length];
			loopcounter[5] = new int[6];
			counter[6] = new int[3];
			loopcounter[6] = new int[13];

			for(int i = 0; i<N; i++){
				cube = new Cube();
				cube.scramble(S, false);
				Solutions.FBcross(cube);
				loopcounter[0][Solutions.loopcounter1]++;
				Solutions.FBcorners(cube);
				loopcounter[1][Solutions.loopcounter2]++;
				Solutions.FB2l(cube);
				loopcounter[2][Solutions.loopcounter3]++;
				Solutions.FBtopcross(cube);
				loopcounter[3][Solutions.loopcounter4]++;
				Solutions.FBpermcross(cube);
				loopcounter[4][Solutions.loopcounter5]++;
				Solutions.FBpermcorners(cube);
				loopcounter[5][Solutions.loopcounter6]++;
				Solutions.FBorientcorners(cube);
				loopcounter[6][Solutions.loopcounter7]++;

			}

			counter[0] = Solutions.counter1;
			counter[1] = Solutions.counter2;
			counter[2] = Solutions.counter3;
			counter[3] = Solutions.counter4;
			counter[4] = Solutions.counter5;
			counter[5] = Solutions.counter6;
			counter[6] = Solutions.counter7;
		}else if(method.equals("Fridrich") ){
			counter = new int[4][];
		
			loopcounter = new int[4][];

		
			loopcounter[0] = new int[12];
	
			loopcounter[1] = new int[8];

			loopcounter[2] = new int[5];

			loopcounter[3] = new int[3];
	
		

			for(int i = 0; i<N; i++){
				
				cube = new Cube();
				cube.scramble(S, false);
				Solutions.FBcross(cube);
				loopcounter[0][Solutions.loopcounter1]++;
				Solutions.FF2l(cube);
				loopcounter[1][Solutions.loopcounter2]++;
				Solutions.FOLL(cube);
				loopcounter[2][Solutions.loopcounter3]++;
				Solutions.FPLL(cube);
				loopcounter[3][Solutions.loopcounter4]++;
				

			}

			counter[0] = new int[1];
			counter[1] = new int[1];
			counter[2] = new int[1];
			counter[3] = new int[1];
		
		}else if(method.equals("Ortega") ){
			counter = new int[6][];
		
			loopcounter = new int[6][];

		
			loopcounter[0] = new int[12];
	
			loopcounter[1] = new int[12];

			loopcounter[2] = new int[12];

			loopcounter[3] = new int[25];
			
			loopcounter[4] = new int[12];
			
			loopcounter[5] = new int[12];
	
		

			for(int i = 0; i<N; i++){
				
				cube = new Cube();
				cube.scramble(S, false);
				Solutions.OTC(cube);
				loopcounter[0][Solutions.loopcounter1]++;
				Solutions.OBC(cube);
				loopcounter[1][Solutions.loopcounter2]++;
				Solutions.PAC(cube);
				loopcounter[2][Solutions.loopcounter3]++;
				Solutions.OrtegaEdges(cube);
				loopcounter[3][Solutions.loopcounter4]++;
				Solutions.OrtegaMidges(cube);
				loopcounter[4][Solutions.loopcounter5]++;
				Solutions.OrtegaFinalAdjustments(cube);
				loopcounter[5][Solutions.loopcounter6]++;
				

			}

			counter[0] = new int[1];
			counter[1] = new int[1];
			counter[2] = new int[1];
			counter[3] = new int[1];
			counter[4] = new int[1];
			counter[5] = new int[1];
		
		}
			
		if(p){
			printAnalysis();
		}else{
			printAnalysistoFile(method,S);
		}
	}

	public static void main(String[] args){
		analyse("Ortega",10000,20,false);
		//analyse("CFOP",10000,19,true);
	}
}
