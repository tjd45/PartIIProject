package uk.ac.cam.tjd45.partiiproj;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GenerateARFF{
	private static char[] faceorder = {'F','R','L','U','D','B'};
	private static int X = 3;
	private static int N = 100000;
	
	public static void main(String[] args){
		String title = "3Moves";
		String[] sources = {"Thomas Davidson","January, 2018"};

		String relation = "nextmove";

		genFile(title,sources);

	}

	static void genFile(String filename,String[] srcs){
		try {
			PrintWriter writer = new PrintWriter(filename+".arff");
			writer.println("% 1. Title: " + filename );
			writer.println("%");
			writer.println("% 2. Sources:");
			writer.println("%  (a) Creator: "+srcs[0]);
			writer.println("%  (b) Date: "+srcs[1]);
			writer.println("%");
			writer.println("@RELATION nextturn");
			writer.println();

			for(int i = 0; i<faceorder.length;i++){
				for(int j = 0; j<9;j++){
					writer.println("@ATTRIBUTE "+faceorder[i]+j+" NUMERIC");
				}
			}
			
			writer.println("@ATTRIBUTE nextmove {F,f,R,r,L,l,U,u,D,d,B,b}");
			writer.println();

			writer.println("@DATA");
			
			
			for(int i = 0;i<N;i++){
				Cube cube = new Cube();
				writer.print(genCase(cube));
			}
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String genCase(Cube cube){
		return cube.arffScramble(X);
	}
	
}