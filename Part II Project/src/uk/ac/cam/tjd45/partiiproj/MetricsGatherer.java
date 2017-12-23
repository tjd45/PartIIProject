package uk.ac.cam.tjd45.partiiproj;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MetricsGatherer {

	public static void main(String[] args){
		String algorithm = "";
		long duration = 0;
		
		Cube cube = new Cube();

		int clength = 0;
		int rlength = 0;
		float[] averages = new float[20];

		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("FridrichBeginnerPerformance.csv"));

			StringBuilder sb = new StringBuilder();

			sb.append("X-moves");
			sb.append(',');
			sb.append("Moves to Solve");
			sb.append('\n');
			
			//long startTime = System.nanoTime();
			
			
			for(int i=0;i<20;i++){
				rlength=0;
				sb.append(i+1);
				for(int j = 0;j<10000;j++){

					cube = new Cube();
					cube.scramble(i+1,false);

					algorithm = Solutions.solve(cube,"FridrichB",false);

					clength = (algorithm.length());

					
					sb.append(',');
					sb.append(clength);
					

										


					rlength+=clength;

				}
				sb.append('\n');
				averages[i]=(float)rlength/10000;

			}
			
			long endTime = System.nanoTime();

			//duration = (endTime - startTime);
			pw.write(sb.toString());

			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<20;i++){
			System.out.println(i+1+" moves: "+averages[i]);
		}

		System.out.println(duration);

	}
}
