package uk.ac.cam.tjd45.partiiproj;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import weka.core.DenseInstance;
import weka.core.Instance;

public class Cube{
	private int N = 3; //3x3x3 Rubik's cube
	protected byte[][] Fface; //Front face
	protected byte[][] Bface; //Back face
	protected byte[][] Rface; //Right face
	protected byte[][] Lface; //Left face
	protected byte[][] Uface; //Up face
	protected byte[][] Dface; //Down face
	protected byte[][] Tempface; //Temporary face

	private int moveNo = 0; //Keeps track of number of moves
	private char lastMove; //Tells you what the last move was

	//ArrayList of all faces to allow iteration over all faces, ie when printing
	private ArrayList<byte[][]> Faces = new ArrayList<byte[][]>(); 

	//Array of colours for prettyPrint
	private char[] colourRef = "WOGRYB".toCharArray();

	private boolean solved; //Whether the cube is solved
	private boolean print = true; //Whether the cube state will be printed after each turn, default true

	//Create a cube in the solved state
	Cube(){
		//initialise byte arrays
		Fface = new byte[N][N];
		Bface = new byte[N][N];
		Rface = new byte[N][N];
		Lface = new byte[N][N];
		Uface = new byte[N][N];
		Dface = new byte[N][N];
		Tempface = new byte[N][N];

		Faces.add(Fface);
		Faces.add(Bface);
		Faces.add(Rface);
		Faces.add(Lface);
		Faces.add(Uface);
		Faces.add(Dface);

		//set the cube so that it is solved
		/*Colour allocation, assigned with Green as front face and traditional net of a cube
		 * 0=White
		 * 1=Orange
		 * 2=Green
		 * 3=Red
		 * 4=Yellow
		 * 5=Blue 
		 */
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				Fface[i][j]=2;
				Bface[i][j]=5;
				Rface[i][j]=3;
				Lface[i][j]=1;
				Uface[i][j]=0;
				Dface[i][j]=4;
			}
		}
	}

	//Alternative constructor to create a cube and scramble it in one
	Cube(String scramble){
		this();
		this.prettyPrint();
		this.performAlgorithm(scramble, false);
	}

	Cube(Cube copy){
		//initialise byte arrays
		Fface = new byte[N][N];
		Bface = new byte[N][N];
		Rface = new byte[N][N];
		Lface = new byte[N][N];
		Uface = new byte[N][N];
		Dface = new byte[N][N];
		Tempface = new byte[N][N];

		Faces.add(Fface);
		Faces.add(Bface);
		Faces.add(Rface);
		Faces.add(Lface);
		Faces.add(Uface);
		Faces.add(Dface);

		//set the cube so that it is solved
		/*Colour allocation, assigned with Green as front face and traditional net of a cube
		 * 0=White
		 * 1=Orange
		 * 2=Green
		 * 3=Red
		 * 4=Yellow
		 * 5=Blue 
		 */
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				Fface[i][j]=copy.Fface[i][j];
				Bface[i][j]=copy.Bface[i][j];
				Rface[i][j]=copy.Rface[i][j];
				Lface[i][j]=copy.Lface[i][j];
				Uface[i][j]=copy.Uface[i][j];
				Dface[i][j]=copy.Dface[i][j];
			}
		}
	}

	Boolean solved(){


		for(byte[][] Face : this.Faces){
			for(int i = 0; i<3; i++){
				for(int j = 0; j<3; j++){
					if(Face[i][j]!=Face[1][1]){
						return false;
					}
				}
			}
		}

		return true;
	}

	String arffScramble(int X){

		boolean holder = print;
		print = false;
		char[] moves = {'F','f','U','u','R','r','L','l','D','d','B','b'};
		Random rn = new Random();
		String arff = "";
		String currarff = "";

		for(int i = 0;i<X;i++){
			currarff="";
			char move = moves[rn.nextInt(12)];
			this.turn(move);
			currarff+=this.arffPrint();
			if(Character.isUpperCase(move)){
				currarff += Character.toLowerCase(move);
			}else if(Character.isLowerCase(move)){
				currarff += Character.toUpperCase(move);
			}

			currarff+="\n";
			if(!this.solved()){
				arff += currarff;
			}
		}

		print = holder;
		return arff;
	}
	
	//Function to scramble a cube using a set number of turns
		String scramble(int X,boolean p){
			if(!p){
				print = false;
			}
			char[] moves = {'F','f','U','u','R','r','L','l','D','d','B','b'};
			Random rn = new Random();

			boolean valid = false;
			String scramble = "";
			String checkvalid = "";
			while(!valid){

				scramble = "";
				
				for(int i = 0;i<X;i++){
					char move = moves[rn.nextInt(12)];
					scramble += move;
				}

				checkvalid = Solutions.prune(scramble);
				if(checkvalid.length()==scramble.length()){
					valid = true;
				}
			}
			this.performAlgorithm(scramble, false);
			if(p)
				System.out.println("Cube scrambled with a "+X+" move scramble: "+scramble);
			print = true;
			return scramble;
		}
		
		//Function to scramble a cube using a set number of turns
		String analyseScramble(int X,boolean p){
			if(!p){
				print = false;
			}
			char[] moves = {'F','f','U','u','R','r','L','l','D','d','B','b'};
			Random rn = new Random();

			boolean valid = false;
			String scramble = "";
			String checkvalid = "";
			String realscramble = "";
			while(!valid){

				scramble = "";
				
				for(int i = 0;i<X;i++){
					char move = moves[rn.nextInt(12)];
					this.turn(move);
					scramble += move;
					realscramble += move;
				}

				checkvalid = Solutions.prune(scramble);
				if(checkvalid.length()==scramble.length()){
					valid = true;
				}
			}
			if(p)
				System.out.println("Cube scrambled with a "+X+" move scramble: "+scramble);
			
			print = true;
			return realscramble;
		}
	//Original function to scramble a cube using a set number of turns, later found to be flawed
	String flawedScramble(int X,boolean p){
		if(!p){
			print = false;
		}
		char[] moves = {'F','f','U','u','R','r','L','l','D','d','B','b'};
		Random rn = new Random();

		boolean valid = false;
		String scramble = "";
		String checkvalid = "";
		while(!valid){

			scramble = "";
			
			for(int i = 0;i<X;i++){
				char move = moves[rn.nextInt(12)];
				this.turn(move);
				scramble += move;
			}

			checkvalid = Solutions.prune(scramble);
			if(checkvalid.length()==scramble.length()){
				valid = true;
			}
		}
		if(p)
			System.out.println("Cube scrambled with a "+X+" move scramble: "+scramble);
		print = true;
		return scramble;
	}

	String experimentScrambles(int pNum){
		String scrambles = "Participant "+pNum+"\n";
		String scram = "";
		for(int i = 2; i<11; i++){
			System.out.println(i+" move scramble");
			for(int j = 0; j<3; j++){
				scram = scramble(i,false);
				scrambles += scram + ",";
				System.out.println(scram);
			}
			scrambles+=";";
		}

		PrintWriter experiment;
		try {
			experiment = new PrintWriter(new FileWriter("ControlledExperimentScrambles.txt", true));
			experiment.append(scrambles+"\n");

			experiment.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return scrambles;




	}

	//crude print function to display raw state of cube
	void print(){
		for(int i = 0; i<Faces.size();i++){
			System.out.println("Face "+i);
			for(int j = 0;j<N;j++){
				for(int k = 0;k<N;k++){
					System.out.print(j+""+k+":"+Faces.get(i)[j][k]+" ");
				}
				System.out.println();
			}
		}
	}

	//user friendly print function to display cube as a net and with letters instead of numbers
	void prettyPrint(){

		if(print&&moveNo>0){
			System.out.println("Move no."+moveNo+": "+lastMove);
		}
		//print TFace
		printFace(Faces.get(4));

		//print the Lface, Fface and Rface
		for(int i = 0; i<N; i++){
			for(int j = 0; j<N; j++){
				System.out.print(colourRef[Lface[i][j]]);
			}
			System.out.print(" ");
			for(int j = 0; j<N; j++){
				System.out.print(colourRef[Fface[i][j]]);
			}
			System.out.print(" ");
			for(int j = 0; j<N; j++){
				System.out.print(colourRef[Rface[i][j]]);
			}
			System.out.println();
		}

		//printDface
		printFace(Faces.get(5));
		//printBface
		printFace(Faces.get(1));

		System.out.println();
	}

	String arffPrint(){
		String arff = "";
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Fface[i][j]+",";
			}
		}
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Rface[i][j]+",";
			}
		}
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Lface[i][j]+",";
			}
		}
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Uface[i][j]+",";
			}
		}
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Dface[i][j]+",";
			}
		}
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				arff+=Bface[i][j]+",";
			}
		}

		return arff;
	}
	void printFace(byte[][] face){
		for(int i = 0; i<N; i++){
			System.out.print("    ");
			for(int j = 0; j<N; j++){
				System.out.print(colourRef[face[i][j]]);
			}
			System.out.println();
		}
	}

	void performAlgorithm(String alg, boolean p){
		
		//Split the provided algorithm string into a character array
		char[] move = alg.toCharArray();
		//Set the global print variable to the value passed to the function (by default global print is true)
		print = p;
		
		//loop over the algorithm string
		for(int i = 0;i<move.length;i++){
			//this string variable was used when debugging
			lastMove=move[i];
			
			//calls the turn function which mutates the cube faces depending on the passed character
			turn(move[i]);
		}
		
		//reset print to true
		print = true;
	}

	void turn(char T){
		switch(T){
		case 'R' : rightTurn(print);
		break;
		case 'r' : rightprimeTurn(print);
		break;
		case 'F' : frontTurn(print);
		break;
		case 'f' : frontprimeTurn(print);
		break;
		case 'L' : leftTurn(print);
		break;
		case 'l' : leftprimeTurn(print);
		break;
		case 'U' : upTurn(print);
		break;
		case 'u' : upprimeTurn(print);
		break;
		case 'D' : downTurn(print);
		break;
		case 'd' : downprimeTurn(print);
		break;
		case 'B' : backTurn(print);
		break;
		case 'b' : backprimeTurn(print);
		break;
		case 'X' : xTurn(print);
		break;
		case 'x' : xprimeTurn(print);
		break;
		case 'Y' : yTurn(print);
		break;
		case 'y' : yprimeTurn(print);
		break;
		case 'Z' : zTurn(print);
		break;
		case 'z' : zprimeTurn(print);
		break;
		case 'M' : rightTurn(false);leftprimeTurn(false);xprimeTurn(print);
		break;
		case 'm' : rightprimeTurn(false);leftTurn(false);xTurn(print);
		}
	}

	void rightTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[i][N-1]=Uface[i][N-1];
			Uface[i][N-1]=Fface[i][N-1];
			Fface[i][N-1]=Dface[i][N-1];
			Dface[i][N-1]=Bface[i][N-1];
			Bface[i][N-1]=Tempface[i][N-1];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Rface[0][0];
		Rface[0][0]=Rface[2][0];
		Rface[2][0]=Rface[2][2];
		Rface[2][2]=Rface[0][2];
		Rface[0][2]=Temp;
		//Then edges
		Temp = Rface[0][1];
		Rface[0][1]=Rface[1][0];
		Rface[1][0]=Rface[2][1];
		Rface[2][1]=Rface[1][2];
		Rface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	void rightprimeTurn(boolean p){

		//Movement of the edges of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[i][N-1]=Bface[i][N-1];
			Bface[i][N-1]=Dface[i][N-1];
			Dface[i][N-1]=Fface[i][N-1];
			Fface[i][N-1]=Uface[i][N-1];
			Uface[i][N-1]=Tempface[i][N-1];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Rface[0][2];
		Rface[0][2]=Rface[2][2];
		Rface[2][2]=Rface[2][0];
		Rface[2][0]=Rface[0][0];
		Rface[0][0]=Temp;

		//Then edges
		Temp = Rface[1][2];
		Rface[1][2]=Rface[2][1];
		Rface[2][1]=Rface[1][0];
		Rface[1][0]=Rface[0][1];
		Rface[0][1]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	void frontTurn(boolean p){

		//Movement of edge cells of face being turned
		for(int i = 0;i<N;i++){
			Tempface[N-1][i]=Uface[N-1][i];
			Uface[N-1][i]=Lface[N-i-1][N-1];
			Lface[N-i-1][N-1]=Dface[0][N-i-1];
			Dface[0][N-i-1]=Rface[i][0];
			Rface[i][0]=Tempface[N-1][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Fface[0][0];
		Fface[0][0]=Fface[2][0];
		Fface[2][0]=Fface[2][2];
		Fface[2][2]=Fface[0][2];
		Fface[0][2]=Temp;
		//Then edges
		Temp = Fface[0][1];
		Fface[0][1]=Fface[1][0];
		Fface[1][0]=Fface[2][1];
		Fface[2][1]=Fface[1][2];
		Fface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void frontprimeTurn(boolean p){

		//Movement of edge cells of face being turned
		for(int i = 0;i<N;i++){
			Tempface[N-1][i]=Rface[i][0];
			Rface[i][0]=Dface[0][N-i-1];
			Dface[0][N-i-1]=Lface[N-i-1][N-1];
			Lface[N-i-1][N-1]=Uface[N-1][i];
			Uface[N-1][i]=Tempface[N-1][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Fface[0][2];
		Fface[0][2]=Fface[2][2];
		Fface[2][2]=Fface[2][0];
		Fface[2][0]=Fface[0][0];
		Fface[0][0]=Temp;

		//Then edges
		Temp = Fface[1][2];
		Fface[1][2]=Fface[2][1];
		Fface[2][1]=Fface[1][0];
		Fface[1][0]=Fface[0][1];
		Fface[0][1]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void leftTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[i][0]=Uface[i][0];
			Uface[i][0]=Bface[i][0];
			Bface[i][0]=Dface[i][0];
			Dface[i][0]=Fface[i][0];
			Fface[i][0]=Tempface[i][0];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Lface[0][0];
		Lface[0][0]=Lface[2][0];
		Lface[2][0]=Lface[2][2];
		Lface[2][2]=Lface[0][2];
		Lface[0][2]=Temp;
		//Then edges
		Temp = Lface[0][1];
		Lface[0][1]=Lface[1][0];
		Lface[1][0]=Lface[2][1];
		Lface[2][1]=Lface[1][2];
		Lface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void leftprimeTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[i][0]=Fface[i][0];
			Fface[i][0]=Dface[i][0];
			Dface[i][0]=Bface[i][0];
			Bface[i][0]=Uface[i][0];
			Uface[i][0]=Tempface[i][0];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Lface[0][2];
		Lface[0][2]=Lface[2][2];
		Lface[2][2]=Lface[2][0];
		Lface[2][0]=Lface[0][0];
		Lface[0][0]=Temp;

		//Then edges
		Temp = Lface[1][2];
		Lface[1][2]=Lface[2][1];
		Lface[2][1]=Lface[1][0];
		Lface[1][0]=Lface[0][1];
		Lface[0][1]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void upTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[0][i]=Fface[0][i];
			Fface[0][i]=Rface[0][i];
			Rface[0][i]=Bface[N-1][N-1-i];
			Bface[N-1][N-1-i]=Lface[0][i];
			Lface[0][i]=Tempface[0][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Uface[0][0];
		Uface[0][0]=Uface[2][0];
		Uface[2][0]=Uface[2][2];
		Uface[2][2]=Uface[0][2];
		Uface[0][2]=Temp;
		//Then edges
		Temp = Uface[0][1];
		Uface[0][1]=Uface[1][0];
		Uface[1][0]=Uface[2][1];
		Uface[2][1]=Uface[1][2];
		Uface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void upprimeTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[0][i]=Lface[0][i];
			Lface[0][i]=Bface[N-1][N-1-i];
			Bface[N-1][N-1-i]=Rface[0][i];
			Rface[0][i]=Fface[0][i];
			Fface[0][i]=Tempface[0][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Uface[0][2];
		Uface[0][2]=Uface[2][2];
		Uface[2][2]=Uface[2][0];
		Uface[2][0]=Uface[0][0];
		Uface[0][0]=Temp;

		//Then edges
		Temp = Uface[1][2];
		Uface[1][2]=Uface[2][1];
		Uface[2][1]=Uface[1][0];
		Uface[1][0]=Uface[0][1];
		Uface[0][1]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	void downTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[N-1][i]=Fface[N-1][i];
			Fface[N-1][i]=Lface[N-1][i];
			Lface[N-1][i]=Bface[0][N-1-i];
			Bface[0][N-1-i]=Rface[N-1][i];
			Rface[N-1][i]=Tempface[N-1][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Dface[0][0];
		Dface[0][0]=Dface[2][0];
		Dface[2][0]=Dface[2][2];
		Dface[2][2]=Dface[0][2];
		Dface[0][2]=Temp;
		//Then edges
		Temp = Dface[0][1];
		Dface[0][1]=Dface[1][0];
		Dface[1][0]=Dface[2][1];
		Dface[2][1]=Dface[1][2];
		Dface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void downprimeTurn(boolean p){

		//Movement of the edge cells of the face being turned
		for(int i = 0; i<N; i++){
			Tempface[N-1][i]=Rface[N-1][i];
			Rface[N-1][i]=Bface[0][N-1-i];
			Bface[0][N-1-i]=Lface[N-1][i];
			Lface[N-1][i]=Fface[N-1][i];
			Fface[N-1][i]=Tempface[N-1][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Dface[0][2];
		Dface[0][2]=Dface[2][2];
		Dface[2][2]=Dface[2][0];
		Dface[2][0]=Dface[0][0];
		Dface[0][0]=Temp;

		//Then edges
		Temp = Dface[1][2];
		Dface[1][2]=Dface[2][1];
		Dface[2][1]=Dface[1][0];
		Dface[1][0]=Dface[0][1];
		Dface[0][1]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void backTurn(boolean p){

		//Movement of edge cells of face being turned
		for(int i = 0;i<N;i++){
			Tempface[0][i]=Uface[0][i];
			Uface[0][i]=Rface[i][N-1];
			Rface[i][N-1]=Dface[N-1][N-i-1];
			Dface[N-1][N-i-1]=Lface[N-i-1][0];
			Lface[N-i-1][0]=Tempface[0][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Bface[0][0];
		Bface[0][0]=Bface[2][0];
		Bface[2][0]=Bface[2][2];
		Bface[2][2]=Bface[0][2];
		Bface[0][2]=Temp;
		//Then edges
		Temp = Bface[0][1];
		Bface[0][1]=Bface[1][0];
		Bface[1][0]=Bface[2][1];
		Bface[2][1]=Bface[1][2];
		Bface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}

	}

	void backprimeTurn(boolean p){

		//Movement of edge cells of face being turned
		for(int i = 0;i<N;i++){
			Tempface[0][i]=Lface[N-i-1][0];
			Lface[N-i-1][0]=Dface[N-1][N-i-1];
			Dface[N-1][N-i-1]=Rface[i][N-1];
			Rface[i][N-1]=Uface[0][i];
			Uface[0][i]=Tempface[0][i];
		}

		//Rotation of the cells on the face being turned
		//Rotate corners first
		byte Temp = Bface[0][2];
		Bface[0][2]=Bface[2][2];
		Bface[2][2]=Bface[2][0];
		Bface[2][0]=Bface[0][0];
		Bface[0][0]=Temp;

		//Then edges
		Temp = Bface[1][2];
		Bface[1][2]=Bface[2][1];
		Bface[2][1]=Bface[1][0];
		Bface[1][0]=Bface[0][1];
		Bface[0][1]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube clockwise around the Rface
	void xTurn(boolean p){
		//swapping of faces as cube is rotated
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Fface[i][j];
				Fface[i][j]=Dface[i][j];
				Dface[i][j]=Bface[i][j];
				Bface[i][j]=Uface[i][j];
				Uface[i][j]=Tempface[i][j];
			}
		}

		//Rotation of the cells on the right face being turned clockwise
		//Rotate corners first
		byte Temp = Rface[0][0];
		Rface[0][0]=Rface[2][0];
		Rface[2][0]=Rface[2][2];
		Rface[2][2]=Rface[0][2];
		Rface[0][2]=Temp;
		//Then edges
		Temp = Rface[0][1];
		Rface[0][1]=Rface[1][0];
		Rface[1][0]=Rface[2][1];
		Rface[2][1]=Rface[1][2];
		Rface[1][2]=Temp;

		//Rotation of the cells on the left face being turned anticlockwise
		//Rotate corners first
		Temp = Lface[0][2];
		Lface[0][2]=Lface[2][2];
		Lface[2][2]=Lface[2][0];
		Lface[2][0]=Lface[0][0];
		Lface[0][0]=Temp;

		//Then edges
		Temp = Lface[1][2];
		Lface[1][2]=Lface[2][1];
		Lface[2][1]=Lface[1][0];
		Lface[1][0]=Lface[0][1];
		Lface[0][1]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube anticlockwise around the Rface
	void xprimeTurn(boolean p){
		//swapping of faces as cube is rotated
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Uface[i][j];
				Uface[i][j]=Bface[i][j];
				Bface[i][j]=Dface[i][j];
				Dface[i][j]=Fface[i][j];
				Fface[i][j]=Tempface[i][j];
			}
		}

		//Rotation of the cells on the right face being turned anticlockwise
		//Rotate corners first
		byte Temp = Rface[0][2];
		Rface[0][2]=Rface[2][2];
		Rface[2][2]=Rface[2][0];
		Rface[2][0]=Rface[0][0];
		Rface[0][0]=Temp;

		//Then edges
		Temp = Rface[1][2];
		Rface[1][2]=Rface[2][1];
		Rface[2][1]=Rface[1][0];
		Rface[1][0]=Rface[0][1];
		Rface[0][1]=Temp;

		//Rotation of the cells on the left face being turned clockwise
		//Rotate corners first
		Temp = Lface[0][0];
		Lface[0][0]=Lface[2][0];
		Lface[2][0]=Lface[2][2];
		Lface[2][2]=Lface[0][2];
		Lface[0][2]=Temp;
		//Then edges
		Temp = Lface[0][1];
		Lface[0][1]=Lface[1][0];
		Lface[1][0]=Lface[2][1];
		Lface[2][1]=Lface[1][2];
		Lface[1][2]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube clockwise around the Uface
	void yTurn(boolean p){
		//swapping of faces as cube is rotated
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Fface[i][j];
				Fface[i][j]=Rface[i][j];
				Rface[i][j]=Bface[N-1-i][N-1-j];
				Bface[N-1-i][N-1-j]=Lface[i][j];
				Lface[i][j]=Tempface[i][j];
			}
		}

		//Rotation of the cells on the up face being turned clockwise
		//Rotate corners first
		byte Temp = Uface[0][0];
		Uface[0][0]=Uface[2][0];
		Uface[2][0]=Uface[2][2];
		Uface[2][2]=Uface[0][2];
		Uface[0][2]=Temp;
		//Then edges
		Temp = Uface[0][1];
		Uface[0][1]=Uface[1][0];
		Uface[1][0]=Uface[2][1];
		Uface[2][1]=Uface[1][2];
		Uface[1][2]=Temp;

		//Rotation of the cells on the down face being turned anticlockwise
		//Rotate corners first
		Temp = Dface[0][2];
		Dface[0][2]=Dface[2][2];
		Dface[2][2]=Dface[2][0];
		Dface[2][0]=Dface[0][0];
		Dface[0][0]=Temp;

		//Then edges
		Temp = Dface[1][2];
		Dface[1][2]=Dface[2][1];
		Dface[2][1]=Dface[1][0];
		Dface[1][0]=Dface[0][1];
		Dface[0][1]=Temp;


		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube anticlockwise around the Uface
	void yprimeTurn(boolean p){
		//swapping of faces as cube is rotated
		for(int i = 0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Fface[i][j];
				Fface[i][j]=Lface[i][j];
				Lface[i][j]=Bface[N-i-1][N-j-1];
				Bface[N-i-1][N-j-1]=Rface[i][j];
				Rface[i][j]=Tempface[i][j];
			}
		}

		//Rotation of the cells on the up face being turned anticlockwise
		//Rotate corners first
		byte Temp = Uface[0][2];
		Uface[0][2]=Uface[2][2];
		Uface[2][2]=Uface[2][0];
		Uface[2][0]=Uface[0][0];
		Uface[0][0]=Temp;

		//Then edges
		Temp = Uface[1][2];
		Uface[1][2]=Uface[2][1];
		Uface[2][1]=Uface[1][0];
		Uface[1][0]=Uface[0][1];
		Uface[0][1]=Temp;

		//Rotation of the cells on the down face being turned clockwise
		//Rotate corners first
		Temp = Dface[0][0];
		Dface[0][0]=Dface[2][0];
		Dface[2][0]=Dface[2][2];
		Dface[2][2]=Dface[0][2];
		Dface[0][2]=Temp;
		//Then edges
		Temp = Dface[0][1];
		Dface[0][1]=Dface[1][0];
		Dface[1][0]=Dface[2][1];
		Dface[2][1]=Dface[1][2];
		Dface[1][2]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube clockwise around the Fface
	void zTurn(boolean p){
		for(int i =0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Lface[N-j-1][i];
				Lface[N-j-1][i]=Dface[N-i-1][N-j-1];
				Dface[N-i-1][N-j-1]=Rface[j][N-i-1];
				Rface[j][N-i-1]=Uface[i][j];
				Uface[i][j]=Tempface[i][j];
			}
		}

		//Rotation of the cells on the front face being turned clockwise
		//Rotate corners first
		byte Temp = Fface[0][0];
		Fface[0][0]=Fface[2][0];
		Fface[2][0]=Fface[2][2];
		Fface[2][2]=Fface[0][2];
		Fface[0][2]=Temp;
		//Then edges
		Temp = Fface[0][1];
		Fface[0][1]=Fface[1][0];
		Fface[1][0]=Fface[2][1];
		Fface[2][1]=Fface[1][2];
		Fface[1][2]=Temp;

		//Rotation of the cells on the back face being turned anticlockwise
		//Rotate corners first
		Temp = Bface[0][2];
		Bface[0][2]=Bface[2][2];
		Bface[2][2]=Bface[2][0];
		Bface[2][0]=Bface[0][0];
		Bface[0][0]=Temp;

		//Then edges
		Temp = Bface[1][2];
		Bface[1][2]=Bface[2][1];
		Bface[2][1]=Bface[1][0];
		Bface[1][0]=Bface[0][1];
		Bface[0][1]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}

	//rotation of the whole cube anticlockwise around the Fface
	void zprimeTurn(boolean p){
		for(int i =0;i<N;i++){
			for(int j = 0;j<N;j++){
				Tempface[i][j]=Uface[i][j];
				Uface[i][j]=Rface[j][N-i-1];
				Rface[j][N-i-1]=Dface[N-i-1][N-j-1];
				Dface[N-i-1][N-j-1]=Lface[N-j-1][i];
				Lface[N-j-1][i]=Tempface[i][j];

			}
		}

		//Rotation of the cells on the front face being turned anticlockwise
		//Rotate corners first
		byte Temp = Fface[0][2];
		Fface[0][2]=Fface[2][2];
		Fface[2][2]=Fface[2][0];
		Fface[2][0]=Fface[0][0];
		Fface[0][0]=Temp;

		//Then edges
		Temp = Fface[1][2];
		Fface[1][2]=Fface[2][1];
		Fface[2][1]=Fface[1][0];
		Fface[1][0]=Fface[0][1];
		Fface[0][1]=Temp;

		//Rotation of the cells on the back face being turned clockwise
		//Rotate corners first
		Temp = Bface[0][0];
		Bface[0][0]=Bface[2][0];
		Bface[2][0]=Bface[2][2];
		Bface[2][2]=Bface[0][2];
		Bface[0][2]=Temp;
		//Then edges
		Temp = Bface[0][1];
		Bface[0][1]=Bface[1][0];
		Bface[1][0]=Bface[2][1];
		Bface[2][1]=Bface[1][2];
		Bface[1][2]=Temp;

		//print cube if print set to true
		if(p){
			this.prettyPrint();
		}
	}
	
	Instance setInstance(Instance inst){
	
		String state = this.arffPrint();
		String[] split = state.split(",");
		
		for(int i = 0; i<54; i++){
			inst.setValue(i, Integer.parseInt(split[i]));
		}
		
		return inst;
		
	}
}
