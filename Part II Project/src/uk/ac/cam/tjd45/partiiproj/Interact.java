package uk.ac.cam.tjd45.partiiproj;
import java.util.Scanner;

public class Interact {

	public static void main(String[] args){
		//Cube cube = new Cube();
		//Cube cube = new Cube("rrRLDdFdlU");

		Cube cube = new Cube();
		System.out.println(cube.solved());
		cube.prettyPrint();
		System.out.println(cube.arffPrint());
		
		
		//System.out.println(cube.arffScramble(3));
		
		String scramble = cube.scramble(1, false);
		System.out.println(cube.solved());
		cube.prettyPrint();
		cube.arffPrint();
		 
		
//		System.out.println(scramble);
//		
//		System.out.println(cube.arffPrint());
//		
		String rev = Solutions.invert(scramble);
		cube.performAlgorithm(rev, false);
		System.out.println(cube.solved());
		cube.prettyPrint();
		
//		System.out.println(rev);
//		
//		cube.performAlgorithm(rev, false);
//		
//		cube.prettyPrint();
		
		//Cube cube = new Cube("RLFLBUBuUF");
		//Solutions.solve(cube, "Fridrich", true);
//		for(int i = 0;i<10;i++){
//		
//		
//			Cube cube = new Cube();
//			cube.scramble(15,false);
//			//
//			//			//cube.prettyPrint();
//			//
//			Solutions.solve(cube,"Fridrich",false);
//			
//			//cube.prettyPrint();
//			//			//cube.prettyPrint();
//			//			
//		}
		//Cube cube = new Cube();



		//		
		//		byte A = cube.Fface[0][0];
		//		byte B = cube.Rface[2][0];
		//		byte C = cube.Uface[0][2];
		//		
		//				char move='a';
		//				Scanner reader = new Scanner(System.in);  // Reading from System.in
		//				while (move!='q'){
		//					move = reader.next().charAt(0);
		//					cube.turn(move);
		//				
		//				}
		//				reader.close(); 

	}

}
