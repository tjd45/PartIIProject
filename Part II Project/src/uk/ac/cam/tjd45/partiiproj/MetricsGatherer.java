package uk.ac.cam.tjd45.partiiproj;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MetricsGatherer {

	public static void main(String[] args){
		int N = 10000;
		String method = "Ortega";
		long duration = 0;
		
		String algorithm = "";
		
		Cube cube = new Cube();
		
		int[] clength = new int[8];
		int[] rlength = new int[8];
		
		int[][] numodd = new int[40][8];
		
		int maxSolve = 250;
		int[] stepSolveLens = new int[8];
		
		
		float[] averages = new float[40];
		int[] solveLens = new int[maxSolve];

		PrintWriter pw,pw2;
		try {
			
			pw = new PrintWriter(new File(method+"PerformanceUD.csv"));
			pw2 = new PrintWriter(new File(method+"PerformanceOverviewUD.csv"));
			
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			sb.append("X-moves");
			sb2.append("X-moves");
			sb.append(',');
			sb2.append(',');
			sb.append("Moves to Solve");
			sb2.append("Moves to Solve");
			sb.append('\n');
			sb2.append('\n');
			sb2.append(',');
			
			for(int i = 0;i<maxSolve;i++){
				sb2.append(i+1+",");
			}
			
			sb2.append('\n');
			
			long startTime = System.nanoTime();
			
			
			for(int i=0;i<40;i++){
				for(int k = 0; k<8;k++){
					rlength[k]=0;	
				}
				java.util.Arrays.fill(solveLens, 0);
				sb.append(i+1);
				sb2.append(i+1);
				for(int j = 0;j<N;j++){
					
					cube = new Cube();
					cube.scramble(i+1,false);

					//algorithm = Solutions.solve(cube,"FridrichB",false);
					stepSolveLens = Solutions.stepSolve(cube, method, false);
					//clength = (algorithm.length());
					//stepSolveLens[7] = Solutions.attemptNeuralSolve(cube,"", 200,false).length();
					for(int k = 0; k<8 ; k++){
						clength[k]=stepSolveLens[k];
						if(clength[k] % 2 == 1){
							
							//System.out.println(k+" ,"+clength[k]);
							numodd[i][k]++;
						}
					}
					//clength = (stepSolveLens[7]);
					
					solveLens[clength[7]]++;
					
					
					
					
					sb.append(',');
					sb.append(clength);
					
					

										

					for(int k = 0; k<8;k++){
						rlength[k]+=clength[k];	
					}
					

				}
				sb2.append(',');
				for(int j = 1;j<maxSolve;j++){
					sb2.append(solveLens[j]);
					sb2.append(',');
				}
				sb.append('\n');
				sb2.append('\n');
				averages[i]=(float)rlength[7]/N;

			}
			
			long endTime = System.nanoTime();

			duration = (endTime - startTime);
			pw.write(sb.toString());
			pw2.write(sb2.toString());
			pw.close();
			pw2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<40;i++){
			System.out.print(i+1+" moves: "+averages[i]);
			for(int j = 0; j<8; j++){
				System.out.print(" O: "+numodd[i][j]+ " E: "+(N-numodd[i][j]));
			}
			System.out.println();
		}

		System.out.println(duration);

	}
}
