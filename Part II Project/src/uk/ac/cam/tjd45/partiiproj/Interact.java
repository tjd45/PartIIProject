package uk.ac.cam.tjd45.partiiproj;
import java.util.Scanner;

public class Interact {

	public static void main(String[] args){
		//Cube cube = new Cube();
		//Cube cube = new Cube("rrRLDdFdlU");

		//		Cube cube = new Cube();
		//		String scramble = cube.scramble(10,false);
		//		String shortscramble = scramble.substring(0, scramble.length()-1);
		//		
		//		Cube cube2 = new Cube();
		//		cube2.performAlgorithm(shortscramble, false);
		//		System.out.println(scramble);
		//		cube.prettyPrint();
		//		System.out.println(shortscramble);
		//		cube2.prettyPrint();
		//		
		//		System.out.println(Solutions.solve(cube, "CFOP", false));
		//		System.out.println(Solutions.solve(cube2, "CFOP", false));
//		for(int i = 0; i<10000; i++){
//			Cube cube = new Cube();
//			cube.scramble(10, false);
//			
//			Solutions.longsolve(cube, "CFOP", false);
//			
//		
//			if(!cube.solved()){
//				System.out.println(i+"failed");
//			}
//		};
		Cube cube = new Cube();
		cube.scramble(20, false);
		
		System.out.println(Solutions.prune(Solutions.solve(cube, "Fridrich", false)));
		
		//cube.experimentScrambles(6);

		//System.out.println(cube.solved());
		//cube.prettyPrint();
		//System.out.println(cube.arffPrint());


		//System.out.println(cube.arffScramble(3));

		//String scramble = cube.scramble(1, false);
		//System.out.println(cube.solved());
		//System.out.println("Ugly Print");
		//cube.print();
		//cube.arffPrint();


		//		System.out.println(scramble);
		//		
		//		System.out.println(cube.arffPrint());
		//		
		//String rev = Solutions.invert(scramble);
		//cube.performAlgorithm(rev, false);
		//System.out.println(cube.solved());
		//System.out.println("\nPretty Print");
		//cube.prettyPrint();

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
