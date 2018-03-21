package uk.ac.cam.tjd45.partiiproj;
public class Solutions {

	private static String algorithm;
	private static int moves;
	private static boolean print;

	protected static String[] crossmoves = {"","uFrf","RRBUU","Ru","DDBBUU","DFRf","LLbUU","lu","Frf","U","fLF","u","ufLF",
			"UU","Frfu","BUU","FFdFF","FRf","FFDFF","flF","fLFU","bUU","BBUU","bFrfu"};

	protected static String[] cornermoves = {"lbLRBr","lbLuBBUBubU","lbLubU","","RBrbRBr","ubUBubU","rBRBubU","DBdRBr",
			"DBdubU","LBBlubU","LblBBubU","LBlBRBr","ubU","RBr","uBBUBubU","bRBr","bubU","buBBUBubU","BRBr","BubU",
			"BuBBUBubU","BBubU","BBuBBUBubU","BBRBr"};

	protected static String[] FB2lmoves = {"","RbrbuBUbRbrbuBU","lBLBUbuuBUBRbr","lBLBUbubRbrbuBU","BRbrbuBU",
			"bbuBUBRbr","BBRbrbuBU","buBUBRbr","DbdbrBRBuBUBRbr","DbdbrBRRbrbuBU","LblbdBDBRbrbuBU","LblbdBDBBuBUBRbr"
			,"RbrbuBU","BuBUBRbr","uBUBRbr","bRbrbuBU"};

	protected static String[][] F2lmoves = {{"FrfR","rUURRURRUR","URUrUURUr","YUUlULUYLUlYY","uRurURUr","RurUUfuF","uRUrURUr",
		"yUruRUUrURY","RUr","rFRf"},
			{"yrUURUruRY","UURRUUruRuRR","RurUUrUURRURRUR","RurfUUF","RUUruRUr","yUURRUURUrURRY","UURUrURur","yurUURurURY",
			"UfuFuUURUrURur","UfuFuufUUFufUF"},
			{"UfUFufuF","yrURUUYRUr","uRurUURur","uRUrUfuF","URur","uRUUrUfuF","uRUUrUURur","yruRY","RurUURUUruRUr","fUFUUyUruRUUrURY"},
			{"URurufUF","UUfUFURur","","rFRfRurURurUURur","ufUFURur","UURurufUF","UufUFURur","RurufUF","fUFURur","uRurufUF"},
			{"fuFUfuF","uRurURur","RuruRUrUURur","RurUfuFufuF","RurURur","UfuFUfuF","UURurURur","ufuFUfuF","URurURur","UUfuFUfuF"},
			{"fUFufUF","uRUruRUr","RUrUURurURUr","RUruRurUUfuF","RUruRUr","UfUFufUF","UURUruRUr","ufUFufUF","URUruRUr","UUfUFufUF"}};

	protected static String[] OLLmoves = {"","RUbLMULLMMxurFRf","rFRfUUrFRFFUUF","YlRRBrBLUUlBmx","rUUXrURuYrurUrFz",
			"RUrUrFRfUUrFRf","mUUMUUmUMUUmUUM","rUUFRUruyRRUUxRUX","FRUrUyrUUrFRf","ruYlUlyLFlFR","RuYRRDrUURdRRUf",
			"FURurURurf","lbLurURurURlBL","lURuLUr","RUrURurURUUr","lURuLUr","rUURUrUR","rfLFRflF","RRDrUURdrUUr","rflFRfLF",
			"muMUUmuM","lRUruLrFRf","LFrFRFFl","FrfRURur","ruRyxRurFRUrX","uRUUruRuRRyruRUB","FRUruRUruf","LflFUULLyLFlF",
			"urUURUrURRYRUruf","RmUUruRurM","rUULMRurUlmUUR","fluLUluLUF","rFrfRRUUxuRUrX","rFRfUURRYrfRf","RUrYrFRurfR",
			"lbLurURlBL","UURmRRuRurUURuM","xuRuRRFXRUruRBB","LuyrUUrURuRUURuf","UUlmLLUlULUUlUM","RRUrbRuRRULMUlm",
			"rMUURUrURm","RUxRurUXur","RUruXdrURzM","rFRUrfRYLul","LfluLFlyrUR","lbLruRUlBL","RBrLUluRbr","FURurf",
			"ruFURurfR","LUfulULFl","fulULF","FRUruf","RUrurFRf","LUlULuluYYrFRf","ruRurURUYFrfR","rFRUruYlUF","LfluLUyRuf"};
	
	protected static String[] PLLmoves = {"","XrUrDDRurDDRRx","xRuRDDrURDDRRX","RRURUrururUr","RuRURURuruRR","MMUMMUUMMUMM",
			"RUrurFRRuruRUrf","rUlUURurUURLu","RUrfRUrurFRRuru","LUUlUULfluLULFLLU","rUURUUrFRUrurfRRu","rUruYrfRRurUrFRF",
			"RRDYrUruRdyRRyrUR","ruRYRRDYrURuRdyRR","RRdyRuRUrDYRRYRur","RUryRRdyRurUrDYRR","rUUruYrfRRurUrFRuF",
			"MMUMMUmUUMMUUmUU","FRuruRUrfRUrurFRf","LuRUUlUrLuRUUlUrU","rUlUURuLrUlUURuLu","xRurDRUrDDYYrURDruRX"};
	
	static String longsolve(Cube cube,String method, boolean p){
		print = p;
		switch(method){
		case "FridrichB" : FridrichB(cube);return semiprune(algorithm);// return prune(algorithm);
		case "Fridrich" : Fridrich(cube);return semiprune(algorithm);
		}
		return "";
	}
	
	static String solve(Cube cube,String method, boolean p){
		print = p;
		switch(method){
		case "FridrichB" : FridrichB(cube);return prune(algorithm);// return prune(algorithm);
		case "Fridrich" : Fridrich(cube);return prune(algorithm);
		}
		return "";
	}
	
	static String attemptNeuralSolve(Cube cube, boolean p, int maxMoves){
		print = p;
		algorithm = "";
		int i = 0;
		
		while(!cube.solved()&&i<maxMoves){
			
			char nm = NeuralNetwork.predictNextMove(cube, "Model_20");
			cube.performAlgorithm(Character.toString(nm), p);
			i++;
			algorithm += nm;
		}
		
		
		return algorithm;
	}
	
	static int[] stepSolve(Cube cube,String method, boolean p){
		print = p;
		int[] steps = new int[8];
		
		switch(method){
		case "FridrichB" : 
		algorithm = "";
		
		FBcross(cube);
		steps[0]=prune(algorithm).length();
		FBcorners(cube);
		steps[1]=prune(algorithm).length()-steps[0];
		FB2l(cube);
		steps[2]=prune(algorithm).length()-steps[1];
		FBtopcross(cube);
		steps[3]=prune(algorithm).length()-steps[2];
		FBpermcross(cube);
		steps[4]=prune(algorithm).length()-steps[3];
		FBpermcorners(cube);
		steps[5]=prune(algorithm).length()-steps[4];
		FBorientcorners(cube);
		steps[6]=prune(algorithm).length()-steps[5];
		steps[7]=prune(algorithm).length();
		
		return steps;// return prune(algorithm);
		case "Fridrich" : 
			algorithm = "";
			FBcross(cube);
			steps[0]=prune(algorithm).length();
			steps[1]=steps[0];
			FF2l(cube);
			steps[2]=prune(algorithm).length()-steps[1];
			steps[3]=steps[2];
			FOLL(cube);
			steps[4]=prune(algorithm).length()-steps[3];
			steps[5]=steps[4];
			FPLL(cube);
			steps[6]=prune(algorithm).length()-steps[5];
			steps[7]=prune(algorithm).length();
			Fridrich(cube);return steps;
		}
		return steps;
	}

	static String invert(String alg){
		String revalg = new StringBuilder(alg).reverse().toString();
		
		char[] revd = revalg.toCharArray();
		
		for(int i = 0;i<revd.length;i++){
			char current = revd[i];
			if(Character.isUpperCase(current)){
				revd[i] = Character.toLowerCase(current);
			}else{
				revd[i] = Character.toUpperCase(current);
			}
		}
		
		return new String(revd);
		
	}
	static String semiprune(String alg){

		alg = alg.replace("Rr", "");
		alg = alg.replace("Uu", "");
		alg = alg.replace("Ll", "");
		alg = alg.replace("Ff", "");
		alg = alg.replace("Dd", "");
		alg = alg.replace("Bb", "");

		alg = alg.replace("rR", "");
		alg = alg.replace("uU", "");
		alg = alg.replace("lL", "");
		alg = alg.replace("fF", "");
		alg = alg.replace("dD", "");
		alg = alg.replace("bB", "");
		
		alg = alg.replace("RRRR", "");
		alg = alg.replace("UUUU", "");
		alg = alg.replace("LLLL", "");
		alg = alg.replace("FFFF", "");
		alg = alg.replace("DDDD", "");
		alg = alg.replace("BBBB", "");

		alg = alg.replace("rrrr", "");
		alg = alg.replace("uuuu", "");
		alg = alg.replace("llll", "");
		alg = alg.replace("ffff", "");
		alg = alg.replace("dddd", "");
		alg = alg.replace("bbbb", "");

		alg = alg.replace("rrr", "R");
		alg = alg.replace("uuu", "U");
		alg = alg.replace("lll", "L");
		alg = alg.replace("fff", "F");
		alg = alg.replace("ddd", "D");
		alg = alg.replace("bbb", "B");

		alg = alg.replace("RRR", "r");
		alg = alg.replace("UUU", "u");
		alg = alg.replace("LLL", "l");
		alg = alg.replace("FFF", "f");
		alg = alg.replace("DDD", "d");
		alg = alg.replace("BBB", "b");

		return alg;

	}
	static String prune(String alg){

		alg = alg.replace("X", "");
		alg = alg.replace("x", "");
		alg = alg.replace("Y", "");
		alg = alg.replace("y", "");
		alg = alg.replace("Z", "");
		alg = alg.replace("z", "");
		
		alg = alg.replace("Rr", "");
		alg = alg.replace("Uu", "");
		alg = alg.replace("Ll", "");
		alg = alg.replace("Ff", "");
		alg = alg.replace("Dd", "");
		alg = alg.replace("Bb", "");
		
		alg = alg.replace("rR", "");
		alg = alg.replace("uU", "");
		alg = alg.replace("lL", "");
		alg = alg.replace("fF", "");
		alg = alg.replace("dD", "");
		alg = alg.replace("bB", "");

		alg = alg.replace("RRRR", "");
		alg = alg.replace("UUUU", "");
		alg = alg.replace("LLLL", "");
		alg = alg.replace("FFFF", "");
		alg = alg.replace("DDDD", "");
		alg = alg.replace("BBBB", "");

		alg = alg.replace("rrrr", "");
		alg = alg.replace("uuuu", "");
		alg = alg.replace("llll", "");
		alg = alg.replace("ffff", "");
		alg = alg.replace("dddd", "");
		alg = alg.replace("bbbb", "");

		alg = alg.replace("rrr", "R");
		alg = alg.replace("uuu", "U");
		alg = alg.replace("lll", "L");
		alg = alg.replace("fff", "F");
		alg = alg.replace("ddd", "D");
		alg = alg.replace("bbb", "B");

		alg = alg.replace("RRR", "r");
		alg = alg.replace("UUU", "u");
		alg = alg.replace("LLL", "l");
		alg = alg.replace("FFF", "f");
		alg = alg.replace("DDD", "d");
		alg = alg.replace("BBB", "b");

		return alg;

	}

	static int getEdgePos(Cube cube,byte A, byte B){
		if(A == cube.Fface[0][1]&&B==cube.Uface[2][1]){
			return 0;
		}else if(B == cube.Fface[0][1]&&A==cube.Uface[2][1]){
			return 1;
		}else if(A == cube.Fface[1][2]&&B==cube.Rface[1][0]){
			return 2;
		}else if(B == cube.Fface[1][2]&&A==cube.Rface[1][0]){
			return 3;
		}else if(A == cube.Fface[2][1]&&B==cube.Dface[0][1]){
			return 4;
		}else if(B == cube.Fface[2][1]&&A==cube.Dface[0][1]){
			return 5;
		}else if(A == cube.Fface[1][0]&&B==cube.Lface[1][2]){
			return 6;
		}else if(B == cube.Fface[1][0]&&A==cube.Lface[1][2]){
			return 7;
		}else if(A == cube.Uface[1][2]&&B==cube.Rface[0][1]){
			return 8;
		}else if(B == cube.Uface[1][2]&&A==cube.Rface[0][1]){
			return 9;
		}else if(A == cube.Uface[1][0]&&B==cube.Lface[0][1]){
			return 10;
		}else if(B == cube.Uface[1][0]&&A==cube.Lface[0][1]){
			return 11;
		}else if(A == cube.Uface[0][1]&&B==cube.Bface[2][1]){
			return 12;
		}else if(B == cube.Uface[0][1]&&A==cube.Bface[2][1]){
			return 13;
		}else if(A == cube.Rface[1][2]&&B==cube.Bface[1][2]){
			return 14;
		}else if(B == cube.Rface[1][2]&&A==cube.Bface[1][2]){
			return 15;
		}else if(A == cube.Rface[2][1]&&B==cube.Dface[1][2]){
			return 16;
		}else if(B == cube.Rface[2][1]&&A==cube.Dface[1][2]){
			return 17;
		}else if(A == cube.Lface[2][1]&&B==cube.Dface[1][0]){
			return 18;
		}else if(B == cube.Lface[2][1]&&A==cube.Dface[1][0]){
			return 19;
		}else if(A == cube.Lface[1][0]&&B==cube.Bface[1][0]){
			return 20;
		}else if(B == cube.Lface[1][0]&&A==cube.Bface[1][0]){
			return 21;
		}else if(A == cube.Bface[0][1]&&B==cube.Dface[2][1]){
			return 22;
		}else if(B == cube.Bface[0][1]&&A==cube.Dface[2][1]){
			return 23;
		}

		return -1;
	}

	static int getCornerPos(Cube cube, byte A, byte B, byte C){
		if(A==cube.Fface[0][0]&&B==cube.Uface[2][0]&&C==cube.Lface[0][2]){
			return 0;
		}else if(C==cube.Fface[0][0]&&A==cube.Uface[2][0]&&B==cube.Lface[0][2]){
			return 1;
		}else if(B==cube.Fface[0][0]&&C==cube.Uface[2][0]&&A==cube.Lface[0][2]){
			return 2;
		}else if(A==cube.Fface[0][2]&&B==cube.Rface[0][0]&&C==cube.Uface[2][2]){
			return 3;
		}else if(C==cube.Fface[0][2]&&A==cube.Rface[0][0]&&B==cube.Uface[2][2]){
			return 4;
		}else if(B==cube.Fface[0][2]&&C==cube.Rface[0][0]&&A==cube.Uface[2][2]){
			return 5;
		}else if(A==cube.Fface[2][2]&&B==cube.Dface[0][2]&&C==cube.Rface[2][0]){
			return 6;
		}else if(B==cube.Fface[2][2]&&C==cube.Dface[0][2]&&A==cube.Rface[2][0]){
			return 7;
		}else if(C==cube.Fface[2][2]&&A==cube.Dface[0][2]&&B==cube.Rface[2][0]){
			return 8;
		}else if(A==cube.Fface[2][0]&&B==cube.Lface[2][2]&&C==cube.Dface[0][0]){
			return 9;
		}else if(B==cube.Fface[2][0]&&C==cube.Lface[2][2]&&A==cube.Dface[0][0]){
			return 10;
		}else if(C==cube.Fface[2][0]&&A==cube.Lface[2][2]&&B==cube.Dface[0][0]){
			return 11;
		}else if(A==cube.Uface[0][2]&&B==cube.Rface[0][2]&&C==cube.Bface[2][2]){
			return 12;
		}else if(C==cube.Uface[0][2]&&A==cube.Rface[0][2]&&B==cube.Bface[2][2]){
			return 13;
		}else if(B==cube.Uface[0][2]&&C==cube.Rface[0][2]&&A==cube.Bface[2][2]){
			return 14;
		}else if(A==cube.Uface[0][0]&&B==cube.Bface[2][0]&&C==cube.Lface[0][0]){
			return 15;
		}else if(B==cube.Uface[0][0]&&C==cube.Bface[2][0]&&A==cube.Lface[0][0]){
			return 16;
		}else if(C==cube.Uface[0][0]&&A==cube.Bface[2][0]&&B==cube.Lface[0][0]){
			return 17;
		}else if(A==cube.Dface[2][2]&&B==cube.Bface[0][2]&&C==cube.Rface[2][2]){
			return 18;
		}else if(B==cube.Dface[2][2]&&C==cube.Bface[0][2]&&A==cube.Rface[2][2]){
			return 19;
		}else if(C==cube.Dface[2][2]&&A==cube.Bface[0][2]&&B==cube.Rface[2][2]){
			return 20;
		}else if(A==cube.Dface[2][0]&&B==cube.Lface[2][0]&&C==cube.Bface[0][0]){
			return 21;
		}else if(B==cube.Dface[2][0]&&C==cube.Lface[2][0]&&A==cube.Bface[0][0]){
			return 22;
		}else if(C==cube.Dface[2][0]&&A==cube.Lface[2][0]&&B==cube.Bface[0][0]){
			return 23;
		}

		cube.prettyPrint();
		System.out.println("Can't find edge "+A+" "+B+" "+ C);
		return -1;
	}

	static void Fridrich(Cube cube){
		algorithm = "";
		if(print)
			System.out.println("Solving...");

		FBcross(cube);
		FF2l(cube);
		FOLL(cube);
		FPLL(cube);
		if(print)
			System.out.println("Solution algorithm: "+algorithm);
	}

	static String PerformF2lMove(Cube cube, byte c1, byte c2, byte c3, byte e1, byte e2){
		int CP = getCornerPos(cube,c1,c2,c3);
		int EP = getEdgePos(cube,e1,e2);
		String alg = "";
		boolean ready = false;
		while(!ready){
			//Check if corner is in acceptable place
			if(CP>2&&CP<9){
				//Check if edge in acceptable place
				if(EP!=14&&EP!=15&&EP!=6&&EP!=7&&EP!=20&&EP!=21){
					//perform move add to alg
					CP=CP-3;
					if(EP>5){
						EP=EP-4;
					}

					//System.out.println(CP+","+EP+": "+F2lmoves[CP][EP]);
					
					cube.performAlgorithm(F2lmoves[CP][EP], false);
					alg+=F2lmoves[CP][EP];
					
					

					ready = true;
				}else{
					if(EP<8){
						cube.performAlgorithm("luLU", false);
						alg+="luLU";
					}else if(EP<16){
						cube.performAlgorithm("BUbu", false);
						alg+="BUbu";
					}else{
						cube.performAlgorithm("bUBu", false);
						alg+="bUBu";
					}

					CP = getCornerPos(cube,c1,c2,c3);
					EP = getEdgePos(cube,e1,e2);
				}

			}else{//Move corner into acceptable place
				if(CP<3){
					cube.performAlgorithm("u", false);
					alg+='u';
				}else if(CP>8&&CP<12){
					cube.performAlgorithm("lUL", false);
					alg+="lUL";
				}else if(CP>11&&CP<15){
					cube.performAlgorithm("U", false);
					alg+='U';
				}else if(CP>14&CP<18){
					cube.performAlgorithm("UU", false);
					alg+="UU";
				}else if(CP>17&&CP<21){
					cube.performAlgorithm("rURU", false);
					alg+="rURU"
							+ "";
				}else if(CP>20&&CP<24){
					cube.performAlgorithm("LUlU", false);
					alg+="LUlU";
				}


				CP = getCornerPos(cube,c1,c2,c3);
				EP = getEdgePos(cube,e1,e2);
			}

		}
		
		return alg;
	}

	static void FF2l(Cube cube){
		String currentalgorithm = "";
		boolean layer =false;
		int f2l=0;

		cube.performAlgorithm("x", false);
		currentalgorithm += 'x';

		while(!layer){
			if((cube.Fface[2][2]==cube.Fface[1][1])&&(cube.Fface[1][2]==cube.Fface[1][1])&&
					(cube.Rface[2][0]==cube.Rface[1][1])&&(cube.Rface[1][0]==cube.Rface[1][1])&&
					(cube.Dface[0][2]==cube.Dface[1][1])){
				cube.performAlgorithm("Y", false);
				currentalgorithm += 'Y';
				f2l++;
				if(f2l==4){
					layer = true;
				}
			}else{
				currentalgorithm+=PerformF2lMove(cube,cube.Fface[1][1], cube.Dface[1][1], cube.Rface[1][1],
						cube.Fface[1][1], cube.Rface[1][1]);

			}
		}

		if((cube.Fface[1][2]==cube.Fface[1][1])&&(cube.Fface[2][2]==cube.Fface[1][1])&&
				(cube.Rface[1][0]==cube.Rface[1][1])&&(cube.Rface[2][0]==cube.Rface[1][1])&&
				(cube.Rface[1][2]==cube.Rface[1][1])&&(cube.Rface[2][2]==cube.Rface[1][1])&&
				(cube.Bface[1][2]==cube.Bface[1][1])&&(cube.Bface[0][2]==cube.Bface[1][1])&&
				(cube.Bface[1][0]==cube.Bface[1][1])&&(cube.Bface[0][0]==cube.Bface[1][1])&&
				(cube.Lface[2][0]==cube.Lface[1][1])&&(cube.Lface[1][0]==cube.Lface[1][1])&&
				(cube.Fface[1][0]==cube.Fface[1][1])&&(cube.Fface[2][0]==cube.Fface[1][1])&&
				(cube.Lface[1][2]==cube.Lface[1][1])&&(cube.Lface[2][2]==cube.Lface[1][1])){
			if(print)
				System.out.println("First and Second Layer Solved... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{
			System.out.println("Error: F2l not solved, algorithm to this point: " + currentalgorithm);
			cube.prettyPrint();
		}

	}

	static int GetOLLState(Cube cube){
		
		int state = 0;
		
		for(int i = 0;i<3;i++){
			if(cube.Bface[2][i]==cube.Uface[1][1]){
				state = (int) (state + Math.pow(2, i));
			}
			if(cube.Rface[0][i]==cube.Uface[1][1]){
				state = (int) (state + Math.pow(2, (5-i)));
			}
			if(cube.Fface[0][i]==cube.Uface[1][1]){
				state = (int) (state + Math.pow(2, (8-i)));
			}
			if(cube.Lface[0][i]==cube.Uface[1][1]){
				state = (int) (state + Math.pow(2, (11-i)));
			}
		}
		
		//System.out.println(state);
		
		
		
		switch(state){
		case 0: return 0;
		case 3770: return 1;
		case 3546: return 2;
		case 1691: return 3;
		case 3506: return 4;
		case 1686: return 5;
		case 1170: return 6;
		case 1714: return 7;
		case 1175: return 8;
		case 1337: return 9;
		case 3640: return 10;
		case 427: return 11;
		case 2730: return 12;
		case 297: return 13;
		case 2600: return 14;
		case 2308: return 15;
		case 521: return 16;
		case 68: return 17;
		case 320: return 18;
		case 516: return 19;
		case 18: return 20;
		case 130: return 21;
		case 217: return 22;
		case 408: return 23;
		case 2452: return 24;
		case 149: return 25;
		case 2772: return 26;
		case 469: return 27;
		case 1157: return 28;
		case 3488: return 29;
		case 1185: return 30;
		case 1449: return 31;
		case 3780: return 32;
		case 1477: return 33;
		case 595: return 34;
		case 310: return 35;
		case 2326: return 36;
		case 562: return 37;
		case 3654: return 38;
		case 1099: return 39;
		case 1570: return 40;
		case 1547: return 41;
		case 1080: return 42;
		case 2186: return 43;
		case 2438: return 44;
		case 203: return 45;
		case 651: return 46;
		case 2214: return 47;
		case 184: return 48;
		case 1409: return 49;
		case 212: return 50;
		case 3712: return 51;
		case 2690: return 52;
		case 387: return 53;
		case 3138: return 54;
		case 282: return 55;
		case 646: return 56;
		case 163: return 57;
		
		}
		
		return -1;
		
	}
	
	static void FOLL(Cube cube){
		String currentalgorithm = "";
		int shift = 0;
		boolean oriented = false;
		int move = -1;
		
		while(!oriented){
			move = GetOLLState(cube);
			if(move==0){
				oriented = true;
			}else{
				if(move == -1){
					if(shift==4){
						System.out.println("Error: Top layer not oriented, algorithm to this point: " + currentalgorithm);
						oriented = true;
					}else{
						cube.performAlgorithm("Y", false);
						currentalgorithm = currentalgorithm + 'Y';
						shift++;
					}
					
				}else{
				
					cube.performAlgorithm(OLLmoves[move],false);
					
					currentalgorithm = currentalgorithm + OLLmoves[move];
				}
				
			}
		}
	
		if((print)&&(shift!=4))
			System.out.println("Top Layer Oriented... " + currentalgorithm);
		algorithm = algorithm + currentalgorithm;
		
		
	}

static int GetPLLState(Cube cube){
		
		String state = "";
		String[] faceList = new String[6];
		
		faceList[(int)cube.Bface[1][1]]="B";
		faceList[(int)cube.Fface[1][1]]="F";
		faceList[(int)cube.Rface[1][1]]="R";
		faceList[(int)cube.Lface[1][1]]="L";
		faceList[(int)cube.Uface[1][1]]="U";
		faceList[(int)cube.Dface[1][1]]="D";
		
		
		for(int i = 0;i<3;i++){
			state = state + faceList[(int)cube.Bface[2][i]];
		}for(int i = 2;i>-1;i--){
			state = state + faceList[(int)cube.Rface[0][i]];
		}for(int i = 2;i>-1;i--){
			state = state + faceList[(int)cube.Fface[0][i]];
		}for(int i = 2;i>-1;i--){
			state = state + faceList[(int)cube.Lface[0][i]];
		}
		
		//System.out.println(state);
		
		switch(state){
		case "BBBRRRFFFLLL": return 0;
		case "RBRFRLBFFLLB": return 1;
		case "BBFLRBRFRFLL": return 2;
		case "BBBRFRFLFLRL": return 3;
		case "BBBRLRFRFLFL": return 4;
		case "BFBRLRFBFLRL": return 5;
		case "BBRFLBRFFLRL": return 6;
		case "RLLBRRFFFLBB": return 7;
		case "BBRFFBRRFLLL": return 8;
		case "RBLBRRFLFLFB": return 9;
		case "RBLBFRFRFLLB": return 10;
		case "FRBRBLBFFLLR": return 11;
		case "RLFLBRFFLBRB": return 12;
		case "LFBRRLBLRFBF": return 13;
		case "LBBRFLBLRFRF": return 14;
		case "RLFLRRFBLBFB": return 15;
		case "BBBRLFLFRFRL": return 16;
		case "BLBRFRFRFLBL": return 17;
		case "FLBRRLBFFLBR": return 18;
		case "FFBRRLBBFLLR": return 19;
		case "BFFLRRFBBRLL": return 20;
		case "LBRFRBRFLBLF": return 21;
		}
		
		return -1;
		
	}

	static void FPLL(Cube cube){
		String currentalgorithm = "";
		boolean permuted = false;
		int sitch = 0;
		int shift = 0;
		
		int move = -1;
		
		while(!permuted){
			move = GetPLLState(cube);
			if(move==0){
				permuted = true;
			}else{
				if(move == -1){
					if(sitch==4){
						if(shift==4){
							System.out.println("Error: Top layer not permuted, algorithm to this point: " + currentalgorithm);
							permuted = true;
						}else{
							cube.performAlgorithm("Y", false);
							currentalgorithm = currentalgorithm + 'Y';
							shift++;
							sitch=0;
						}
					}else{
						cube.performAlgorithm("U", false);
						currentalgorithm = currentalgorithm + 'U';
						sitch++;
					}
					
				}else{
					cube.performAlgorithm(PLLmoves[move],false);
					//System.out.println(move);
					currentalgorithm = currentalgorithm + PLLmoves[move];
				}
				
			}
		}
		
		if((print)&&(shift!=4))
			System.out.println("Top Layer permuted... " + currentalgorithm);
		algorithm = algorithm + currentalgorithm;
		
		
		
		
		
	}

	static void FridrichB(Cube cube){
		algorithm = "";
		if(print)
			System.out.println("Solving...");

		FBcross(cube);
		FBcorners(cube);
		FB2l(cube);
		FBtopcross(cube);
		FBpermcross(cube);
		FBpermcorners(cube);
		FBorientcorners(cube);
		if(print)
			System.out.println("Solution algorithm: "+algorithm);
	}

	static void FBcross(Cube cube){
		boolean cross = false;
		int limbs = 0;

		while(!cross){
			if((cube.Fface[0][1]==cube.Fface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
				cube.performAlgorithm("Z",false);
				algorithm = algorithm + 'Z';
				limbs++;
				if(limbs == 4){
					cross = true;
				}
			}else{
				int move = getEdgePos(cube,cube.Fface[1][1],cube.Uface[1][1]);
				cube.performAlgorithm(crossmoves[move], false);
				algorithm = algorithm + crossmoves[move];
			}
		}

		if((cube.Fface[0][1]==cube.Fface[1][1])&&
				(cube.Fface[1][2]==cube.Fface[1][1])&&
				(cube.Fface[2][1]==cube.Fface[1][1])&&
				(cube.Fface[1][0]==cube.Fface[1][1])&&
				(cube.Uface[2][1]==cube.Uface[1][1])&&
				(cube.Rface[1][0]==cube.Rface[1][1])&&
				(cube.Dface[0][1]==cube.Dface[1][1])&&
				(cube.Lface[1][2]==cube.Lface[1][1])){
			if(print)
				System.out.println("Cross Solved... " + algorithm);
		}else{
			System.out.println("Error: Cross not solved, algorithm to this point: " + algorithm);
			cube.prettyPrint();
		}

	}

	static void FBcorners(Cube cube){

		String currentalgorithm ="";
		boolean layer = false;
		int limbs = 0;

		while(!layer){
			if((cube.Fface[0][2]==cube.Fface[1][1])&&(cube.Uface[2][2]==cube.Uface[1][1])&&(cube.Rface[0][0]==cube.Rface[1][1])){
				cube.performAlgorithm("Z",false);
				currentalgorithm = currentalgorithm + 'Z';
				limbs++;
				if(limbs == 4){
					layer = true;
				}
			}else{
				int move = getCornerPos(cube,cube.Fface[1][1],cube.Rface[1][1],cube.Uface[1][1]);
				cube.performAlgorithm(cornermoves[move], false);
				currentalgorithm = currentalgorithm + cornermoves[move];
			}
		}

		if((cube.Fface[0][2]==cube.Fface[1][1])&&(cube.Uface[2][2]==cube.Uface[1][1])&&(cube.Rface[0][0]==cube.Rface[1][1])&&
				(cube.Fface[2][2]==cube.Fface[1][1])&&(cube.Rface[2][0]==cube.Rface[1][1])&&(cube.Dface[0][2]==cube.Dface[1][1])&&
				(cube.Fface[0][2]==cube.Fface[1][1])&&(cube.Dface[0][0]==cube.Dface[1][1])&&(cube.Lface[2][2]==cube.Lface[1][1])&&
				(cube.Fface[0][0]==cube.Fface[1][1])&&(cube.Lface[0][2]==cube.Lface[1][1])&&(cube.Uface[2][0]==cube.Uface[1][1])
				){
			if(print)
				System.out.println("Bottom Corners Solved... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{
			System.out.println("Error: Corners not solved, algorithm to this point: " + currentalgorithm);
			cube.prettyPrint();
		}

	}

	static void FB2l(Cube cube){
		String currentalgorithm = "";
		boolean l2 = false;
		int limbs = 0;

		while(!l2){
			if((cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Rface[0][1]==cube.Rface[1][1])){
				cube.performAlgorithm("Z",false);
				currentalgorithm = currentalgorithm + 'Z';
				limbs++;
				if(limbs == 4){
					l2 = true;
				}
			}else{
				int move = getEdgePos(cube,cube.Uface[1][1],cube.Rface[1][1]);
				cube.performAlgorithm(FB2lmoves[move-8], false);
				currentalgorithm = currentalgorithm + FB2lmoves[move-8];
			}
		}

		if((cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Rface[0][1]==cube.Rface[1][1])&&
				(cube.Rface[2][1]==cube.Rface[1][1])&&(cube.Dface[1][2]==cube.Dface[1][1])&&
				(cube.Dface[1][0]==cube.Dface[1][1])&&(cube.Lface[2][1]==cube.Lface[1][1])&&
				(cube.Lface[0][1]==cube.Lface[1][1])&&(cube.Uface[1][0]==cube.Uface[1][1])
				){
			cube.performAlgorithm("x", false);

			currentalgorithm=currentalgorithm+'x';
			if(print)
				System.out.println("Second Layer Solved..." + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{

			System.out.println("Error: Second Layer not solved, algorithm to this point: " + currentalgorithm);
			cube.prettyPrint();
		}






	}

	static String TopLayerState(Cube cube){
		if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])){
			return "bar";
		}else if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return "line";
		}else if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[0][1]==cube.Uface[1][1])){
			return "arrow1";
		}else if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])){
			return "arrow2";
		}else if((cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return "arrow3";
		}else if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return "arrow4";
		}else{
			return "dot";
		}
	}

	static void FBtopcross(Cube cube){
		String currentalgorithm = "";
		boolean cross = false;
		int limbs = 0;

		while(!cross){
			if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
				cross=true;
			}else{
				String state = TopLayerState(cube);
				switch(state){
				case "bar" : cube.performAlgorithm("FRUruf",false);currentalgorithm=currentalgorithm+"FRUruf";
				break;
				case "line" : cube.performAlgorithm("UFRUruf",false);currentalgorithm=currentalgorithm+"UFRUruf";
				break;
				case "dot" : cube.performAlgorithm("FRUruRUrufUFRUruf",false);currentalgorithm=currentalgorithm+"FRUruRUrufUFRUruf";
				break;
				case "arrow1" : cube.performAlgorithm("FRUruRUruf",false);currentalgorithm=currentalgorithm+"FRUruRUruf";
				break;
				case "arrow2" : cube.performAlgorithm("uFRUruRUruf",false);currentalgorithm=currentalgorithm+"uFRUruRUruf";
				break;
				case "arrow3" : cube.performAlgorithm("FRUrufUFRUruf",false);currentalgorithm=currentalgorithm+"FRUrufUFRUruf";
				break;
				case "arrow4" : cube.performAlgorithm("UFRUruRUruf",false);currentalgorithm=currentalgorithm+"UFRUruRUruf";
				break;
				}

			}
		}

		if(print)
			System.out.println("Top Cross Solved..." + currentalgorithm);
		algorithm = algorithm + currentalgorithm;
	}

	static int NoEdgesInPlace(Cube cube){
		int counter = 0;

		if(cube.Fface[0][1]==cube.Fface[1][1]){
			counter+=1;
		}

		if(cube.Rface[0][1]==cube.Rface[1][1]){
			counter+=2;
		}

		if(cube.Lface[0][1]==cube.Lface[1][1]){
			counter+=4;
		}

		if(cube.Bface[2][1]==cube.Bface[1][1]){
			counter+=8;
		}

		return counter;

	}

	static void FBpermcross(Cube cube){
		boolean permed = false;
		int state = 0;
		String currentalgorithm = "";

		while(!permed){
			state = NoEdgesInPlace(cube);
			switch(state){
			case 0:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';
			break;
			case 1:cube.performAlgorithm("RUrURUUr", false);currentalgorithm=currentalgorithm+"RURURUUr";
			break;
			case 2:cube.performAlgorithm("BUbUBUUb", false);currentalgorithm=currentalgorithm+"BUbUBUUb";
			break;
			case 3:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';
			break;
			case 4:cube.performAlgorithm("FUfUFUUf", false);currentalgorithm=currentalgorithm+"FUfUFUUf";
			break;
			case 5:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';
			break;
			case 6:cube.performAlgorithm("RUrURUUr", false);currentalgorithm=currentalgorithm+"FUfUFUUf";
			break;
			case 8:cube.performAlgorithm("LUlULUUl", false);currentalgorithm=currentalgorithm+"LUlULUUl";
			break;
			case 9:cube.performAlgorithm("RUrURUUrU", false);currentalgorithm=currentalgorithm+"RUrURUUrU";
			break;
			case 10:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';
			break;
			case 12:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';
			break;
			case 15:permed = true;
			break;
			}
		}

		if((cube.Rface[0][1]==cube.Rface[1][1])&&(cube.Fface[0][1]==cube.Fface[1][1])&&(cube.Lface[0][1]==cube.Lface[1][1])&&(cube.Bface[2][1]==cube.Bface[1][1])){
			if(print)
				System.out.println("Top Cross Permutation Solved..."+currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{
			System.out.println("Error: Top Cross not solved, algorithm to this point: " + currentalgorithm);
			cube.prettyPrint();
		}


	}

	static int NoCornersInPlace(Cube cube){
		int counter = 0;

		if(getCornerPos(cube, cube.Fface[1][1], cube.Uface[1][1], cube.Lface[1][1])<3){
			counter+=1;
		}

		if(getCornerPos(cube, cube.Fface[1][1], cube.Rface[1][1], cube.Uface[1][1])<6&&getCornerPos(cube, cube.Fface[1][1], cube.Rface[1][1], cube.Uface[1][1])>2){
			counter+=2;
		}

		if(getCornerPos(cube, cube.Uface[1][1], cube.Rface[1][1], cube.Bface[1][1])<15&&getCornerPos(cube, cube.Uface[1][1], cube.Rface[1][1], cube.Bface[1][1])>11){
			counter+=4;
		}

		if(getCornerPos(cube, cube.Uface[1][1], cube.Bface[1][1], cube.Lface[1][1])<18&&getCornerPos(cube, cube.Uface[1][1], cube.Bface[1][1], cube.Lface[1][1])>14){
			counter+=8;
		}

		return counter;

	}

	static void FBpermcorners(Cube cube){
		boolean permed = false;
		int state = 0;
		String currentalgorithm = "";

		while(!permed){
			state = NoCornersInPlace(cube);
			switch(state){
			case(0):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(1):cube.performAlgorithm("UFubUfuB", false);currentalgorithm=currentalgorithm+"UFubUfuB";
			break;
			case(2):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(3):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(4):cube.performAlgorithm("UBufUbuF", false);currentalgorithm=currentalgorithm+"UBufUbuF";
			break;
			case(5):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(6):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(8):cube.performAlgorithm("ULurUluR", false);currentalgorithm=currentalgorithm+"ULurUluR";
			break;
			case(9):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(10):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(12):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			break;
			case(15):permed=true;
			break;
			}
		}


		if(print)
			System.out.println("Final Corners Permutation Solved..."+currentalgorithm);
		algorithm = algorithm + currentalgorithm;

	}

	static void FBorientcorners(Cube cube){
		boolean solved = false;
		int corners = 0;
		String currentalgorithm = "";
		while(!solved){
			if((cube.Fface[0][2]==cube.Fface[0][1])&&(cube.Rface[0][0]==cube.Rface[0][1])){
				corners ++;
				cube.performAlgorithm("U", false);
				currentalgorithm=currentalgorithm+'U';
				if (corners == 4){
					solved = true;
				}
			}else{
				cube.performAlgorithm("rdRDrdRD", false);
				currentalgorithm=currentalgorithm+"rdRDrdRD";
			}
		}
		if(print)
			System.out.println("Final Corners Orientation Solved..."+currentalgorithm);
		algorithm = algorithm + currentalgorithm;
	}

}
