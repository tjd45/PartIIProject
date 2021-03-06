package uk.ac.cam.tjd45.partiiproj;
import java.util.Scanner;

public class Interact {

	public static void main(String[] args){
		//Initialise the cube
//		Cube cube = new Cube();
//		//Display the inital solved state of the cube
//		cube.prettyPrint();
//		
//		//Define a new scanner to read from System.in
//		Scanner reader = new Scanner(System.in); 
//		//Define a string to hold the current input
//		String input = reader.nextLine();
//		
//		//Loop until the user quits
//		while(!input.equals("q")){
//			//Perform the inputted move on the cube with the print variable set to true
//			cube.performAlgorithm(input, true);
//			//get the next move when the user is ready
//			input = reader.nextLine();
//		}; 
//		
		//reader.close();
		
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



		//		int oddcounter = 0;
		//		int evencounter = 0;
		//		for(int i = 0;i<10000;i++){
		//			Cube cube = new Cube();
		//			Cube cubeT = new Cube();
		//			String scram = cubeT.scramble(19, false);
		//
		//			cube.performAlgorithm(scram, false);
		//
		//			Cube cube2 = new Cube();
		//			cube2.performAlgorithm(scram, false);
		//
		//			Cube cube3 = new Cube();
		//			cube3.performAlgorithm(scram, false);
		//
		//			String sol = Solutions.solve(cubeT, "CFOP", false);
		//
		//			String longsol = Solutions.longsolve(cube2, "CFOP", false);
		//			String longlongsol = Solutions.longlongsolve(cube3, "CFOP", false);
		//
		//
		//			if(sol.length()%2==1){
		//				oddcounter++;
		//				//System.out.println("Odd: "+sol.length());
		//			}else{
		//				evencounter++;
		//				//				if(sol.length()<10){
		//				//					System.out.println();
		//				//					System.out.println("Scramble :"+scram);
		//				//					System.out.println("Even: "+sol.length()+" : "+sol);
		//				//					String OE = (((longsol.length()&2)==1) ? "Odd" : "Even");
		//				//					System.out.println(OE+": "+longsol.length()+" "+longsol);
		//				//					String prune = Solutions.prune(longsol);
		//				//					OE = (((prune.length()%2)== 1) ? "Odd" : "Even");
		//				//					System.out.println(OE+": "+prune.length()+" :"+prune);
		//				//					OE = (((longlongsol.length()%2)== 1) ? "Odd" : "Even");
		//				//					System.out.println(OE+": "+longlongsol.length()+" "+longlongsol);
		//				//					prune = Solutions.prune(longlongsol);
		//				//					OE = (((prune.length()%2)== 1) ? "Odd" : "Even");
		//				//					System.out.println(OE+": "+prune.length()+" :"+prune);
		//				//					System.out.println();
		//				//				}
		//
		//			}
		//		}
		//
		//
		//		//		System.out.println("Number of odd: "+oddcounter);
		//		//		System.out.println("Number of even: "+evencounter);
		//
		//		oddcounter = 0;
		//		evencounter = 0;
		//		int oddScounter = 0;
		//		int evenScounter = 0;
		//		for(int i = 0; i < 100000; i++){
		//			Cube cube = new Cube();
		//			String scram = cube.analyseScramble(19, false);
		//
		//			String sol = Solutions.solve(cube, "CFOP", false);
		//
		//			if(sol.length()%2==1){
		//				oddcounter++;
		//			}else{
		//				evencounter++;
		//			}
		//			if(scram.length()%2==1){
		//				oddScounter++;
		//			}else
		//				evenScounter++;
		//		}
		//	
		//
		//	System.out.println("Number of odd solves: "+oddcounter+" Number of odd scrambles: "+oddScounter);
		//	System.out.println("Number of even solves: "+evencounter+" Number of even scrambles: "+evenScounter);



		//		for(int i = 0; i<10; i++){
		//		Cube cube = new Cube();
		//		cube.performAlgorithm("brb", false);
		//		String sol = Solutions.solve(cube, "CFOP", false);
		//		System.out.println(sol.length()+":"+sol);
		//		}
		
		String longsolve = "";
		String prunesolve = "";
		String scram = "";
		int totlength = 0;
		int diflength = 0;
		for(int i = 0; i<100000;i++){
			Cube cube = new Cube();
			scram = cube.scramble(20, false);
			Cube cube2 = new Cube();
			cube2.performAlgorithm(scram, false);
			
			longsolve = Solutions.longlongsolve(cube, "CFOP", false);
			prunesolve = Solutions.solve(cube2, "CFOP", false);
			
			totlength+=longsolve.length();
			diflength+=(longsolve.length()-prunesolve.length());
			
			
		}
		
		System.out.println((double)diflength/(double)totlength);
       //Cube cube = new Cube();
//         cube.prettyPrint();
//         cube.scramble(10, false);
//         cube.prettyPrint();
         
         //Solutions.solve(cube, "Ortega", true);
	//cube.experimentScrambles(20);

		//Cube cube = new Cube();
//		cube.scramble(50, false);
//		Solutions.solve(cube, "Ortega", false);
		
		//cube.prettyPrint();
//		Cube cube = new Cube();
//		cube.analyseScramble(20, false);
//		Solutions.stepSolve(cube, "CFOP", false);
//		for(int i = 0; i< 10000; i++){
//			Cube cube = new Cube();
//
//			//System.out.println(cube.scramble(10, false));
//			cube.scramble(10, false);
//
//			Solutions.solve(cube, "Ortega", false);
//
//			//cube.prettyPrint();
//
//		}



//				Cube cube = new Cube();
//				cube.performAlgorithm("DfUfUDlUlR", false);
//				cube.prettyPrint();
//				Solutions.solve(cube, "Ortega", false);

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
