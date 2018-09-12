package uk.ac.cam.tjd45.partiiproj;
public class Solutions {

	private static String algorithm;
	private static int moves;
	private static boolean print;
	protected static String defaultModel = "Model_80";


	protected static String[] crossmoves = {"","uFrf","RRBUU","Ru","DDBBUU","DFRf","LLbUU","lu","Frf","U","fLF","u","ufLF",
			"UU","Frfu","BUU","FFdFF","FRf","FFDFF","flF","fLFU","bUU","BBUU","bFrfu"};

	protected static String[] cornermoves = {"lbLRBr","lbLuBBUBubU","lbLubU","","RBrbRBr","ubUBubU","rBRBubU","DBdRBr",
			"DBdubU","LBBlubU","LblBBubU","LBlBRBr","ubU","RBr","uBBUBubU","bRBr","bubU","buBBUBubU","BRBr","BubU",
			"BuBBUBubU","BBubU","BBuBBUBubU","BBRBr"};

	protected static String[] FB2lmoves = {"","RbrbuBUbRbrbuBU","lBLBUbuuBUBRbr","lBLBUbubRbrbuBU","BRbrbuBU",
			"bbuBUBRbr","BBRbrbuBU","buBUBRbr","DbdbrBRBuBUBRbr","DbdbrBRRbrbuBU","LblbdBDBRbrbuBU","LblbdBDBBuBUBRbr"
			,"RbrbuBU","BuBUBRbr","uBUBRbr","bRbrbuBU"};

	protected static String[] topCrossMoves = {"FRUruf","UFRUruf","FRUruRUrufUFRUruf","FRUruRUruf",
			"uFRUruRUruf","FRUrufUFRUruf","UFRUruRUruf"};

	protected static String[] tcPermMoves = {"U","RUrURUUr","BUbUBUUb","U","FUfUFUUf","U","RUrURUUr","LUlULUUl",
			"RUrURUUrU","U","U"};

	protected static String[] tcorPermMoves = {"URulUruL","UFubUfuB","URulUruL","URulUruL","UBufUbuF","URulUruL",
			"URulUruL","ULurUluR","URulUruL","URulUruL","URulUruL"};

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

	protected static String[] OTCmoves = {"fDf","","F","FDfdFDf","rdRDrdR","","FDf","rdR","rDDRDrdR","DrdR","DrDDRDrdR","DFDf","","RuBU","r","","bLUlB","bDrdB","drDDRDrdR","dFDf",
			"ULDDlu","rdRFDf","dUUlDLUU","DDrdR"};

	protected static String[] OBCmoves = {"","RUrufuF","FrfurUR","RUrURUUr","ruRurUUR","RURRfRRUr","rfuFUR","RRUUrUURR"};


	protected static int[] counter1 = new int[crossmoves.length];
	protected static int[] counter2 = new int[cornermoves.length];
	protected static int[] counter3 = new int[FB2lmoves.length];
	protected static int[] counter4 = new int[topCrossMoves.length];
	protected static int[] counter5 = new int[tcPermMoves.length];
	protected static int[] counter6 = new int[tcorPermMoves.length];
	protected static int[] counter7 = new int[3];
	protected static int loopcounter1 = 0;
	protected static int loopcounter2 = 0;
	protected static int loopcounter3 = 0;
	protected static int loopcounter4 = 0;
	protected static int loopcounter5 = 0;
	protected static int loopcounter6 = 0;
	protected static int loopcounter7 = 0;

	static String longlongsolve(Cube cube,String method, boolean p){
		print = p;
		switch(method){
		case "CFOP" : FridrichB(cube);return algorithm;// return prune(algorithm);
		case "Fridrich" : Fridrich(cube);return algorithm;
		case "Ortega": Ortega(cube);return algorithm;
		}
		return "";
	}

	static String longsolve(Cube cube,String method, boolean p){
		print = p;
		switch(method){
		case "CFOP" : FridrichB(cube);return semiprune(algorithm);// return prune(algorithm);
		case "Fridrich" : Fridrich(cube);return semiprune(algorithm);
		case "Ortega": Ortega(cube);return semiprune(algorithm);
		}
		return "";
	}

	static String solve(Cube cube,String method, boolean p){
		print = p;
		switch(method){
		case "CFOP" : FridrichB(cube);return prune(algorithm);// return prune(algorithm);
		case "Fridrich" : Fridrich(cube);return prune(algorithm);
		case "Ortega" : Ortega(cube);return prune(algorithm);
		}
		return "";
	}
	
	static String attemptHybridSolve(Cube cube,String method, String model, int maxMoves, int backTrackIndex, boolean p){
		print = p;
		algorithm = "";
		String currentalgorithm = "";
		if(method.equals("Fridrich")){
			FBcross(cube);
			FF2l(cube);
			FOLL(cube);
		}else if(method.equals("CFOP")){
			FBcross(cube);
			FBcorners(cube);
			FB2l(cube);
			FBtopcross(cube);
			FBpermcross(cube);
		}
		currentalgorithm = algorithm;
		currentalgorithm+=attemptdoubleBackNeuralSolve(cube,model,maxMoves,backTrackIndex,p);
		
		return algorithm;
	}

	static String attemptdoubleBackNeuralSolve(Cube cube, String model, int maxMoves, int backTrackIndex, boolean p){
		print = p;
		algorithm = "";
		int backtracks = 0;

		if(model.length()==0){
			model = defaultModel;
		}

		int i = 0;
		String currentalg = "";
		boolean second = false;
		while(!cube.solved()&&i<maxMoves){


			char nm = NeuralNetwork.predictNextMove(cube, model,second);
			second = false;
			cube.performAlgorithm(Character.toString(nm), p);
			i++;
			currentalg += nm;
			algorithm += nm;


			if(flipflop(currentalg)){

				String rev = invert(currentalg);
				String revalg;
				if(backtracks==0){


					if(backTrackIndex == -1){
						if(rev.length()>2){
							revalg = rev.substring(2,3);
						}else{
							revalg = rev.substring(2,2);
						}

					}else{
						if(rev.length()-1>(backTrackIndex)){
							revalg = rev.substring(2,rev.length()-(backTrackIndex-1));
						}else{
							revalg = rev.substring(2,2);
						}
						backTrackIndex=-1;
						backtracks++;
					}




				}
				else{
					if(rev.length()>2){
						revalg = rev.substring(2,3);
					}else{
						revalg = rev.substring(2,2);
					}

				}
				cube.performAlgorithm(revalg, false);
				second = true;
				algorithm += revalg;

				currentalg = currentalg.substring(0,(currentalg.length()-revalg.length()));
			}

		}



		return prune(algorithm);
	}

	static String attemptSimpleBackNeuralSolve(Cube cube, String model, int maxMoves, int backTrackIndex, boolean p){
		print = p;
		algorithm = "";
		if(model.length()==0){
			model = defaultModel;
		}

		int i = 0;
		String currentalg = "";
		boolean second = false;
		while(!cube.solved()&&i<maxMoves){


			char nm = NeuralNetwork.predictNextMove(cube, model,second);
			second = false;
			cube.performAlgorithm(Character.toString(nm), p);
			i++;
			currentalg += nm;
			algorithm += nm;

			if(flipflop(currentalg)){
				String rev = invert(currentalg);
				String revalg;

				revalg = rev.substring(2, rev.length());



				cube.performAlgorithm(revalg, false);
				second = true;
				algorithm += revalg;
				currentalg = "";
			}

		}



		return algorithm;
	}


	static String attemptNeuralSolve(Cube cube, String model, int maxMoves, int backTrackIndex, boolean p){
		print = p;
		algorithm = "";
		if(model.length()==0){
			model = defaultModel;
		}

		int i = 0;
		String currentalg = "";
		boolean second = false;
		while(!cube.solved()&&i<maxMoves){


			char nm = NeuralNetwork.predictNextMove(cube, model,second);
			second = false;
			cube.performAlgorithm(Character.toString(nm), p);
			i++;
			currentalg += nm;
			algorithm += nm;

			if(flipflop(currentalg)){
				String rev = invert(currentalg);
				String revalg;

				if(backTrackIndex == -1){
					if(rev.length()>2){
						revalg = rev.substring(2,3);
					}else{
						revalg = rev.substring(2,2);
					}

				}else{
					if(rev.length()-1>(backTrackIndex)){
						revalg = rev.substring(2,rev.length()-(backTrackIndex-1));
					}else{
						revalg = rev.substring(2,2);
					}
				}



				cube.performAlgorithm(revalg, false);
				second = true;
				algorithm += revalg;
				currentalg = "";
			}

		}



		return algorithm;
	}

	static String attemptSimpleNeuralSolve(Cube cube, String model, int maxMoves, int backTrackIndex, boolean p){
		print = p;
		algorithm = "";
		if(model.length()==0){
			model = defaultModel;
		}

		int i = 0;
		String currentalg = "";
		boolean second = false;
		while(!cube.solved()&&i<maxMoves){


			char nm = NeuralNetwork.predictNextMove(cube, model,second);
			second = false;
			cube.performAlgorithm(Character.toString(nm), p);
			i++;
			currentalg += nm;
			algorithm += nm;



		}



		return algorithm;
	}

	static boolean flipflop(String alg){
		if(alg.length()>1){
			char[] checker = alg.toCharArray();

			char last = checker[alg.length()-1];
			char slast = checker[alg.length()-2];



			if(Character.isUpperCase(last)){
				if(Character.isLowerCase(slast)){

					if(last == Character.toUpperCase(slast)){
						return true;
					}
				}
			}else{
				if(Character.isUpperCase(slast)){

					if(last == Character.toLowerCase(slast)){
						return true;
					}
				}
			}

			if(alg.length()>3){
				char tlast = checker[alg.length()-3];
				char flast = checker[alg.length()-4];

				if((last==slast)&&(slast==tlast)&&(tlast==flast)){
					return true;
				}
			}
		}

		return false;

	}

	static int[] stepSolve(Cube cube,String method, boolean p){
		print = p;
		int[] steps = new int[8];

		switch(method){
		case "CFOP" : 
			algorithm = "";

			FBcross(cube);
			steps[0]=prune(algorithm).length();
			
			FBcorners(cube);
			steps[1]=prune(algorithm).length()-steps[0];
			
			FB2l(cube);
			steps[2]=prune(algorithm).length()-steps[1]-steps[0];
			
			FBtopcross(cube);
			steps[3]=prune(algorithm).length()-steps[2]-steps[1]-steps[0];
			
			FBpermcross(cube);
			steps[4]=prune(algorithm).length()-steps[3]-steps[2]-steps[1]-steps[0];
			
			FBpermcorners(cube);
			steps[5]=prune(algorithm).length()-steps[4]-steps[3]-steps[2]-steps[1]-steps[0];
			
			FBorientcorners(cube);
			steps[6]=prune(algorithm).length()-steps[5]-steps[4]-steps[3]-steps[2]-steps[1]-steps[0];
			
			steps[7]=prune(algorithm).length();
			

			
			//		System.out.println(loopcounter1);
			//		for(int i = 0; i<crossmoves.length; i++){
			//			System.out.println("Move "+i+" used "+counter1[i]+" times");
			//		}

			return steps;// return prune(algorithm);
		case "Fridrich" : 
			algorithm = "";
			FBcross(cube);
			steps[0]=prune(algorithm).length();
			FF2l(cube);
			steps[1]=prune(algorithm).length()-steps[0];
			FOLL(cube);
			steps[2]=prune(algorithm).length()-steps[1]-steps[0];
			FPLL(cube);
			steps[3]=prune(algorithm).length()-steps[2]-steps[1]-steps[0];
			steps[4]=prune(algorithm).length();
			steps[5]=0;
			steps[6]=0;
			steps[7]=steps[4];
			return steps;
		case "Ortega" : 
			algorithm = "";
			OTC(cube);
			steps[0]=prune(algorithm).length();
			OBC(cube);
			steps[1]=prune(algorithm).length()-steps[0];
			PAC(cube);
			steps[2]=prune(algorithm).length()-steps[1];
			OrtegaEdges(cube);
			steps[3]=prune(algorithm).length()-steps[2];
			OrtegaMidges(cube);
			steps[4]=prune(algorithm).length()-steps[3];
			OrtegaFinalAdjustments(cube);
			steps[5]=prune(algorithm).length()-steps[4];
			steps[6]=0;
			steps[7]=prune(algorithm).length();
		}
		
		
		
		
		return steps;
	}

	static int[] longStepSolve(Cube cube,String method, boolean p){
		print = p;
		int[] steps = new int[8];

		switch(method){
		case "CFOP" : 
			algorithm = "";

			FBcross(cube);
			steps[0]=algorithm.length();
			FBcorners(cube);
			steps[1]=algorithm.length()-steps[0];
			FB2l(cube);
			steps[2]=algorithm.length()-steps[1];
			FBtopcross(cube);
			steps[3]=algorithm.length()-steps[2];
			FBpermcross(cube);
			steps[4]=algorithm.length()-steps[3];
			FBpermcorners(cube);
			steps[5]=algorithm.length()-steps[4];
			FBorientcorners(cube);
			steps[6]=algorithm.length()-steps[5];
			steps[7]=algorithm.length();

			return steps;// return prune(algorithm);
		case "Fridrich" : 
			algorithm = "";
			FBcross(cube);
			steps[0]=algorithm.length();
			FF2l(cube);
			steps[1]=algorithm.length()-steps[0];
			FOLL(cube);
			steps[2]=algorithm.length()-steps[1]-steps[0];
			FPLL(cube);
			steps[3]=algorithm.length()-steps[2]-steps[1]-steps[0];
			steps[4]=algorithm.length();
			steps[5]=0;
			steps[6]=0;
			steps[7]=steps[4];return steps;
		case "Ortega" : 
			algorithm = "";
			OTC(cube);
			steps[0]=algorithm.length();
			OBC(cube);
			steps[1]=algorithm.length()-steps[0];
			PAC(cube);
			steps[2]=algorithm.length()-steps[1];
			OrtegaEdges(cube);
			steps[3]=algorithm.length()-steps[2];
			OrtegaMidges(cube);
			steps[4]=algorithm.length()-steps[3];
			OrtegaFinalAdjustments(cube);
			steps[5]=algorithm.length()-steps[4];
			steps[6]=0;
			steps[7]=algorithm.length();
		}
		return steps;
	}

	static int[] sliceStepSolve(Cube cube,String method, boolean p){
		print = p;
		int[] steps = new int[8];

		switch(method){
		case "CFOP" : 
			algorithm = "";

			FBcross(cube);
			steps[0]=sliceprune(algorithm).length();
			FBcorners(cube);
			steps[1]=sliceprune(algorithm).length()-steps[0];
			FB2l(cube);
			steps[2]=sliceprune(algorithm).length()-steps[1];
			FBtopcross(cube);
			steps[3]=sliceprune(algorithm).length()-steps[2];
			FBpermcross(cube);
			steps[4]=sliceprune(algorithm).length()-steps[3];
			FBpermcorners(cube);
			steps[5]=sliceprune(algorithm).length()-steps[4];
			FBorientcorners(cube);
			steps[6]=sliceprune(algorithm).length()-steps[5];
			steps[7]=sliceprune(algorithm).length();

			//		System.out.println(loopcounter1);
			//		for(int i = 0; i<crossmoves.length; i++){
			//			System.out.println("Move "+i+" used "+counter1[i]+" times");
			//		}

			return steps;// return prune(algorithm);
		case "Fridrich" : 
			algorithm = "";
			FBcross(cube);
			steps[0]=sliceprune(algorithm).length();
			FF2l(cube);
			steps[1]=sliceprune(algorithm).length()-steps[0];
			FOLL(cube);
			steps[2]=sliceprune(algorithm).length()-steps[1]-steps[0];
			FPLL(cube);
			steps[3]=sliceprune(algorithm).length()-steps[2]-steps[1]-steps[0];
			steps[4]=sliceprune(algorithm).length();
			steps[5]=0;
			steps[6]=0;
			steps[7]=steps[4];
			return steps;
		case "Ortega" : 
			algorithm = "";
			OTC(cube);
			steps[0]=sliceprune(algorithm).length();
			OBC(cube);
			steps[1]=sliceprune(algorithm).length()-steps[0];
			PAC(cube);
			steps[2]=sliceprune(algorithm).length()-steps[1];
			OrtegaEdges(cube);
			steps[3]=sliceprune(algorithm).length()-steps[2];
			OrtegaMidges(cube);
			steps[4]=sliceprune(algorithm).length()-steps[3];
			OrtegaFinalAdjustments(cube);
			steps[5]=sliceprune(algorithm).length()-steps[4];
			steps[6]=0;
			steps[7]=sliceprune(algorithm).length();
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

	static String sliceprune(String alg){

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
		alg = alg.replace("Mm", "");

		alg = alg.replace("rR", "");
		alg = alg.replace("uU", "");
		alg = alg.replace("lL", "");
		alg = alg.replace("fF", "");
		alg = alg.replace("dD", "");
		alg = alg.replace("bB", "");
		alg = alg.replace("mM", "");

		alg = alg.replace("RRRR", "");
		alg = alg.replace("UUUU", "");
		alg = alg.replace("LLLL", "");
		alg = alg.replace("FFFF", "");
		alg = alg.replace("DDDD", "");
		alg = alg.replace("BBBB", "");
		alg = alg.replace("MMMM", "");

		alg = alg.replace("rrrr", "");
		alg = alg.replace("uuuu", "");
		alg = alg.replace("llll", "");
		alg = alg.replace("ffff", "");
		alg = alg.replace("dddd", "");
		alg = alg.replace("bbbb", "");
		alg = alg.replace("mmmm", "");

		alg = alg.replace("rrr", "R");
		alg = alg.replace("uuu", "U");
		alg = alg.replace("lll", "L");
		alg = alg.replace("fff", "F");
		alg = alg.replace("ddd", "D");
		alg = alg.replace("bbb", "B");
		alg = alg.replace("mmm", "M");

		alg = alg.replace("RRR", "r");
		alg = alg.replace("UUU", "u");
		alg = alg.replace("LLL", "l");
		alg = alg.replace("FFF", "f");
		alg = alg.replace("DDD", "d");
		alg = alg.replace("BBB", "b");
		alg = alg.replace("MMM", "m");

		alg = alg.replace("M", "Rl");
		alg = alg.replace("m", "rL");

		return alg;
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
		alg = alg.replace("Mm", "");

		alg = alg.replace("rR", "");
		alg = alg.replace("uU", "");
		alg = alg.replace("lL", "");
		alg = alg.replace("fF", "");
		alg = alg.replace("dD", "");
		alg = alg.replace("bB", "");
		alg = alg.replace("mM", "");

		alg = alg.replace("RRRR", "");
		alg = alg.replace("UUUU", "");
		alg = alg.replace("LLLL", "");
		alg = alg.replace("FFFF", "");
		alg = alg.replace("DDDD", "");
		alg = alg.replace("BBBB", "");
		alg = alg.replace("MMMM", "");

		alg = alg.replace("rrrr", "");
		alg = alg.replace("uuuu", "");
		alg = alg.replace("llll", "");
		alg = alg.replace("ffff", "");
		alg = alg.replace("dddd", "");
		alg = alg.replace("bbbb", "");
		alg = alg.replace("mmmm", "");

		alg = alg.replace("rrr", "R");
		alg = alg.replace("uuu", "U");
		alg = alg.replace("lll", "L");
		alg = alg.replace("fff", "F");
		alg = alg.replace("ddd", "D");
		alg = alg.replace("bbb", "B");
		alg = alg.replace("mmm", "M");

		alg = alg.replace("RRR", "r");
		alg = alg.replace("UUU", "u");
		alg = alg.replace("LLL", "l");
		alg = alg.replace("FFF", "f");
		alg = alg.replace("DDD", "d");
		alg = alg.replace("BBB", "b");
		alg = alg.replace("MMM", "m");

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

	static int getOrtegaCornerPos(Cube cube, byte A){
		if(A==cube.Uface[2][2]){
			return 5;
		}else if(A==cube.Fface[0][0]){
			return 0;
		}else if(A==cube.Lface[0][2]){
			return 2;
		}else if(A==cube.Fface[0][2]){
			return 3;
		}else if(A==cube.Rface[0][0]){
			return 4;
		}else if(A==cube.Fface[2][2]){
			return 6;
		}else if(A==cube.Rface[2][0]){
			return 7;
		}else if(A==cube.Dface[0][2]){
			return 8;
		}else if(A==cube.Fface[2][0]){
			return 9;
		}else if(A==cube.Dface[0][0]){
			return 10;
		}else if(A==cube.Lface[2][2]){
			return 11;
		}else if(A==cube.Rface[0][2]){
			return 13;
		}else if(A==cube.Bface[2][2]){
			return 14;
		}else if(A==cube.Lface[0][0]){
			return 16;
		}else if(A==cube.Bface[2][0]){
			return 17;
		}else if(A==cube.Dface[2][2]){
			return 18;
		}else if(A==cube.Rface[2][2]){
			return 19;
		}else if(A==cube.Bface[0][2]){
			return 20;
		}else if(A==cube.Dface[2][0]){
			return 21;
		}else if(A==cube.Bface[0][0]){
			return 22;
		}else if(A==cube.Lface[2][0]){
			return 23;
		}else if(A==cube.Uface[0][2]){
			return 12;
		}else if(A==cube.Uface[0][0]){
			return 15;
		}else if(A==cube.Uface[2][0]){
			return 1;
		}

		cube.prettyPrint();
		System.out.println("Can't find edge "+A);
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
		loopcounter2=0;

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
				
				loopcounter2++;

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
		loopcounter3=0;

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
					
					loopcounter3++;
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
		loopcounter4=0;
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
					loopcounter4++;
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
		//initialise loop variable to false
		boolean cross = false;
		//initialise variable for keeping track of number of pieces correctly placed
		int limbs = 0;
		//global variable for use within analytics
		loopcounter1 = 0;

		//loop until the cross has been formed
		while(!cross){
			//check if the target piece has been placed correctly
			if((cube.Fface[0][1]==cube.Fface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
				//rotate the cube on its axis
				cube.performAlgorithm("Z",false);
				//record this move
				algorithm = algorithm + 'Z';
				//increment the number of correctly placed pieces
				limbs++;
				//check how many pieces are correctly placed and update the loop variable
				if(limbs == 4){
					cross = true;
				}
			}else{
				//get the position of the target edge
				int move = getEdgePos(cube,cube.Fface[1][1],cube.Uface[1][1]);
				
				//use the returned index to perform the next sub-algorithm
				cube.performAlgorithm(crossmoves[move], false);
				//record the moves on the global algorithm
				algorithm = algorithm + crossmoves[move];
				//update global variables for analytics
				counter1[move]++;
				loopcounter1++;
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
		loopcounter2=0;

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
				counter2[move]++;
				loopcounter2++;
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
		loopcounter3=0;

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
				counter3[move-8]++;
				loopcounter3++;
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

	static int TopLayerState(Cube cube){
		//bar = 0 line = 1 dot = 2 arrow1 = 3 arrow2 = 4 arrow3 = 5 arrow4 = 6
		if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])){
			return 0;
		}else if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return 1;
		}else if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[0][1]==cube.Uface[1][1])){
			return 3;
		}else if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])){
			return 4;
		}else if((cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return 5;
		}else if((cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
			return 6;
		}else{
			return 2;
		}
	}

	static void FBtopcross(Cube cube){
		String currentalgorithm = "";
		boolean cross = false;
		int limbs = 0;
		loopcounter4=0;


		while(!cross){
			if((cube.Uface[0][1]==cube.Uface[1][1])&&(cube.Uface[1][0]==cube.Uface[1][1])&&(cube.Uface[1][2]==cube.Uface[1][1])&&(cube.Uface[2][1]==cube.Uface[1][1])){
				cross=true;
			}else{
				int state = TopLayerState(cube);
				cube.performAlgorithm(topCrossMoves[state], false);
				currentalgorithm = currentalgorithm + topCrossMoves[state];
				counter4[state]++;
				loopcounter4++;
				//				switch(state){
				//				//bar = 0 line = 1 dot = 2 arrow1 = 3 arrow2 = 4 arrow3 = 5 arrow4 = 6
				//				case "bar" : cube.performAlgorithm("FRUruf",false);currentalgorithm=currentalgorithm+"FRUruf";
				//				break;
				//				case "line" : cube.performAlgorithm("UFRUruf",false);currentalgorithm=currentalgorithm+"UFRUruf";
				//				break;
				//				case "dot" : cube.performAlgorithm("FRUruRUrufUFRUruf",false);currentalgorithm=currentalgorithm+"FRUruRUrufUFRUruf";
				//				break;
				//				case "arrow1" : cube.performAlgorithm("FRUruRUruf",false);currentalgorithm=currentalgorithm+"FRUruRUruf";
				//				break;
				//				case "arrow2" : cube.performAlgorithm("uFRUruRUruf",false);currentalgorithm=currentalgorithm+"uFRUruRUruf";
				//				break;
				//				case "arrow3" : cube.performAlgorithm("FRUrufUFRUruf",false);currentalgorithm=currentalgorithm+"FRUrufUFRUruf";
				//				break;
				//				case "arrow4" : cube.performAlgorithm("UFRUruRUruf",false);currentalgorithm=currentalgorithm+"UFRUruRUruf";
				//				break;
				//				}

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
		loopcounter5=0;

		while(!permed){
			state = NoEdgesInPlace(cube);
			switch(state){
			case 0:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';counter5[0]++;
			break;
			case 1:cube.performAlgorithm("RUrURUUr", false);currentalgorithm=currentalgorithm+"RUrURUUr";counter5[1]++;//there was a disparity here where the third r was capitalised in the currentalgorithm
			break;
			case 2:cube.performAlgorithm("BUbUBUUb", false);currentalgorithm=currentalgorithm+"BUbUBUUb";counter5[2]++;
			break;
			case 3:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';counter5[3]++;
			break;
			case 4:cube.performAlgorithm("FUfUFUUf", false);currentalgorithm=currentalgorithm+"FUfUFUUf";counter5[4]++;
			break;
			case 5:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';counter5[5]++;
			break;
			case 6:cube.performAlgorithm("RUrURUUr", false);currentalgorithm=currentalgorithm+"RUrURUUr";counter5[6]++;//another disparity here where this currentalg was same as case 4
			break;
			case 8:cube.performAlgorithm("LUlULUUl", false);currentalgorithm=currentalgorithm+"LUlULUUl";counter5[7]++;
			break;
			case 9:cube.performAlgorithm("RUrURUUrU", false);currentalgorithm=currentalgorithm+"RUrURUUrU";counter5[8]++;
			break;
			case 10:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';counter5[9]++;
			break;
			case 12:cube.performAlgorithm("U", false);currentalgorithm=currentalgorithm+'U';counter5[10]++;
			break;
			case 15:permed = true;
			break;
			}
			loopcounter5++;
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
		loopcounter6=0;

		while(!permed){

			state = NoCornersInPlace(cube);

			if(state!=15){
				if(state>7){

					if(state<11){
						state = state-1;
					}else{
						state=10;
					}
				}

				cube.performAlgorithm(tcorPermMoves[state], false);
				currentalgorithm = currentalgorithm + tcorPermMoves[state];
				counter6[state]++;
				loopcounter6++;
			}else{
				permed = true;
			}

			//			switch(state){
			//			case(0):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(1):cube.performAlgorithm("UFubUfuB", false);currentalgorithm=currentalgorithm+"UFubUfuB";
			//			break;
			//			case(2):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(3):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(4):cube.performAlgorithm("UBufUbuF", false);currentalgorithm=currentalgorithm+"UBufUbuF";
			//			break;
			//			case(5):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(6):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(8):cube.performAlgorithm("ULurUluR", false);currentalgorithm=currentalgorithm+"ULurUluR";
			//			break;
			//			case(9):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(10):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(12):cube.performAlgorithm("URulUruL", false);currentalgorithm=currentalgorithm+"URulUruL";
			//			break;
			//			case(15):permed=true;
			//			break;
			//			}
		}


		if(print)
			System.out.println("Final Corners Permutation Solved..."+currentalgorithm);
		algorithm = algorithm + currentalgorithm;

	}

	static void FBorientcorners(Cube cube){
		boolean solved = false;
		int corners = 0;
		String currentalgorithm = "";
		loopcounter7=0;
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
				loopcounter7++;
			}
		}

		if(currentalgorithm.length()==52){
			counter7[2]++;
		}else if(currentalgorithm.length()==28){
			counter7[1]++;
		}else{
			counter7[0]++;
		}


		if(print)
			System.out.println("Final Corners Orientation Solved..."+currentalgorithm);
		algorithm = algorithm + currentalgorithm;
	}



	static void OTC(Cube cube){
		String currentalgorithm ="";
		String moveselection = "";
		boolean corners = false;
		int limbs = 0;
		loopcounter1=0;
		while(!corners){


			if(cube.Uface[2][2]==cube.Uface[1][1]){
				cube.performAlgorithm("Y",false);
				currentalgorithm = currentalgorithm + 'Y';
				limbs++;
				if(limbs == 4){
					corners = true;
				}
			}else{
				int move = getOrtegaCornerPos(cube,cube.Uface[1][1]);


				cube.performAlgorithm(OTCmoves[move], false);
				currentalgorithm = currentalgorithm + OTCmoves[move];
				moveselection = moveselection + move + ",";
				loopcounter1++;

			}

		}


		if((cube.Uface[0][0]==cube.Uface[1][1])&&(cube.Uface[0][2]==cube.Uface[1][1])&&(cube.Uface[2][0]==cube.Uface[1][1])&&
				(cube.Uface[2][2]==cube.Uface[1][1])){
			if(print)
				System.out.println("Top Corners Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{

			System.out.println("Error: Top corners not placed, algorithm to this point: " + currentalgorithm);
			cube.prettyPrint();
		}

	}

	static int getOrtegaCornerState(Cube cube){

		int state = 0;

		if(cube.Bface[2][0]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 0));
		}
		if(cube.Bface[2][2]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 1));
		}
		if(cube.Rface[0][0]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 2));
		}
		if(cube.Rface[0][2]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 3));
		}
		if(cube.Fface[0][0]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 4));
		}
		if(cube.Fface[0][2]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 5));
		}
		if(cube.Lface[0][0]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 6));
		}
		if(cube.Lface[0][2]==cube.Uface[1][1]){
			state = (int) (state + Math.pow(2, 7));
		}



		//	 System.out.println(state);



		switch(state){
		case 0: return 0;
		case 72: return 1;//T
		case 24: return 2;//L
		case 41: return 3;//Mu
		case 22: return 4;//Inverse Mu
		case 120: return 5;//Pi
		case 3: return 6;//U
		case 51: return 7;


		}

		return -1;

	}

	static void OBC(Cube cube){
		String currentalgorithm ="";
		String moveselection = "";
		boolean corners = false;
		int shift = 0;
		int move;
		loopcounter2=0;

		cube.performAlgorithm("XX", false);
		currentalgorithm+="XX";

		while(!corners){


			if((cube.Uface[0][0]==cube.Uface[1][1])&&(cube.Uface[0][2]==cube.Uface[1][1])&&(cube.Uface[2][0]==cube.Uface[1][1])&&
					(cube.Uface[2][2]==cube.Uface[1][1])){
				corners=true;
			}else{
				move = getOrtegaCornerState(cube);
				if(move==0){
					corners = true;
				}else{
					if(move == -1){
						if(shift==4){
							System.out.println("Error: Bottom corners not placed, algorithm to this point: " + currentalgorithm);
							cube.prettyPrint();
							corners = true;
						}else{
							cube.performAlgorithm("Y", false);
							currentalgorithm = currentalgorithm + 'Y';
							shift++;
						}

					}else{


						cube.performAlgorithm(OBCmoves[move],false);

						moveselection += OBCmoves[move]+",";

						currentalgorithm = currentalgorithm + OBCmoves[move];
						
						loopcounter2++;
					}

				}
			}




		}


		if((cube.Uface[0][0]==cube.Uface[1][1])&&(cube.Uface[0][2]==cube.Uface[1][1])&&(cube.Uface[2][0]==cube.Uface[1][1])&&
				(cube.Uface[2][2]==cube.Uface[1][1])){
			if(print)
				System.out.println("Bottom Corners Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}
	}

	static byte opposite(byte A){
		if(A==0)
			return 4;
		if(A==4)
			return 0;
		if(A==1)
			return 3;
		if(A==3)
			return 1;
		if(A==2)
			return 5;
		if(A==5)
			return 2;

		return -1;
	}

	static boolean[] countPairs(Cube cube){
		boolean[] Pairs = new boolean[8];

		if(cube.Fface[0][0]==cube.Fface[0][2]){
			Pairs[0]=true;
			if(cube.Rface[0][0]==cube.Rface[0][2]){
				Pairs[1]=true;
				Pairs[2]=true;
				Pairs[3]=true;
			}
		}else if(cube.Fface[0][0]==opposite(cube.Fface[0][2])){
			if(cube.Rface[0][0]!=opposite(cube.Rface[0][2])){
				Pairs[2]=true;
			}

		}else if(cube.Rface[0][0]==opposite(cube.Rface[0][2])){
			Pairs[3]=true;
		}else if(cube.Rface[0][0]==cube.Rface[0][2]){
			Pairs[1]=true;
		}

		cube.performAlgorithm("XX", false);

		if(cube.Fface[0][0]==cube.Fface[0][2]){
			Pairs[6]=true;
			if(cube.Rface[0][0]==cube.Rface[0][2]){
				Pairs[5]=true;
				Pairs[4]=true;
				Pairs[7]=true;
			}
		}else if(cube.Fface[0][0]==opposite(cube.Fface[0][2])){
			if(cube.Rface[0][0]!=opposite(cube.Rface[0][2])){
				Pairs[4]=true;
			}

		}else if(cube.Rface[0][0]==opposite(cube.Rface[0][2])){
			Pairs[7]=true;
		}else if(cube.Rface[0][0]==cube.Rface[0][2]){
			Pairs[5]=true;
		}

		cube.performAlgorithm("XX", false);


		return Pairs;
	}

	static int numOrtegaPairs(boolean[] Pairs){
		int state = 0;

		for(int i = 0;i<Pairs.length;i++){
			if(Pairs[i])
				state = (int) (state + Math.pow(2, i));
		}

		//System.out.println(state);

		switch(state){
		case 0: return 0;
		case 64: return 1;
		case 4: return 2;
		case 68: return 3;
		case 240: return 4;
		case 244: return 5;
		case 255: return 6;

		}

		return -1;
	}

	static int numTLayerPairs(boolean[] Pairs){
		int num =0;

		for(int i = 0;i<4;i++){
			if(Pairs[i])
				num++;
		}

		return num;
	}

	static int numBLayerPairs(boolean[] Pairs){
		int num =0;

		for(int i = 4;i<Pairs.length;i++){
			if(Pairs[i])
				num++;
		}

		return num;
	}

	protected static String[] PACmoves = {"RRFFRR","RuFUUfUr","rUrBBRuR","RRUFFUURRURR","FFuRurUFFURUr","RuRFFrURFFRR"};

	static void PAC (Cube cube){
		String currentalgorithm ="";
		String moveselection = "";
		boolean Pairs[] = countPairs(cube);
		int numPairs = numOrtegaPairs(Pairs);
		int loop = 0;
loopcounter3=0;

		while(numPairs!=6){


			if(numPairs!=-1){
				
				cube.performAlgorithm(PACmoves[numPairs], false);
				currentalgorithm+=PACmoves[numPairs];
				moveselection+=numPairs+",";
				loopcounter3++;
			}else{

				if(numTLayerPairs(Pairs)==4){
					cube.performAlgorithm("XX", false);
					currentalgorithm+="XX";
				}else if(numTLayerPairs(Pairs)==1){
					while(!Pairs[2]){
						cube.performAlgorithm("Y", false);
						currentalgorithm+="Y";
						Pairs = countPairs(cube);
					}
					if(numBLayerPairs(Pairs)==1){
						while(!Pairs[6]){
							cube.performAlgorithm("D", false);
							currentalgorithm+="D";
							Pairs = countPairs(cube);
						}
					}
					
				}else if(numTLayerPairs(Pairs)==0){
					while(!Pairs[6]){
						cube.performAlgorithm("Y", false);
						currentalgorithm+="Y";
						Pairs = countPairs(cube);
					}
				}

			}

			loop++;

			//System.out.println("Loop: "+loop);
			Pairs = countPairs(cube);
			numPairs = numOrtegaPairs(Pairs);

			if(loop > 10){
				System.out.println("Error: Corners not placed, algorithm to this point: " + currentalgorithm);
				cube.prettyPrint();
				numPairs =6;
			}

		}

		if((cube.Uface[0][0]==cube.Uface[1][1])&&(cube.Uface[0][2]==cube.Uface[1][1])&&(cube.Uface[2][0]==cube.Uface[1][1])&&(cube.Uface[2][2]==cube.Uface[1][1])&&
				(cube.Dface[0][0]==cube.Dface[1][1])&&(cube.Dface[0][2]==cube.Dface[1][1])&&(cube.Dface[2][0]==cube.Dface[1][1])&&(cube.Dface[2][2]==cube.Dface[1][1])&&
				(cube.Fface[0][2]==cube.Fface[0][0])&&(cube.Rface[0][0]==cube.Rface[0][2])&&(cube.Lface[0][0]==cube.Lface[0][2])&&(cube.Bface[2][0]==cube.Bface[2][2])&&
				(cube.Fface[2][0]==cube.Fface[2][2])&&(cube.Rface[2][0]==cube.Rface[2][2])&&(cube.Lface[2][0]==cube.Lface[2][2])&&(cube.Bface[0][0]==cube.Bface[0][2])){
			if(print)
				System.out.println("All Corners Placed... " + currentalgorithm);
			cube.performAlgorithm("Z", false);
			currentalgorithm+="Z";
			algorithm = algorithm + currentalgorithm;
		}

	}

	static int convertLEdgePos(int Edge){

		switch(Edge){
		case 4 : return 0;
		case 5 : return 1;
		case 9 : return 2;
		case 8 : return 3;
		case 11 : return 4;
		case 0 : return 5;
		case 1 : return 5;
		case 2 : return 6;
		case 3 : return 6;
		case 6 : return 11;
		case 7 : return 11;
		case 12: return 9;
		case 13: return 9;
		case 14: return 8;
		case 15: return 8;
		case 16: return 10;
		case 17: return 10;
		case 18: return 11;
		case 19: return 11;
		case 20: return 11;
		case 21: return 11;
		case 22: return 7;
		case 23: return 7;
		case 10: return 18;
		}


		return -1;
	}

	static int convertExtraLEdgePos(int Edge){

		switch(Edge){
		case 6: return 12;
		case 7: return 13;
		case 18:return 14;
		case 19:return 15;
		case 20:return 16;
		case 21:return 17;
		}


		return -1;
	}

	static void OrtegaEdges (Cube cube){
		loopcounter4=0;
		LEdges(cube);
		REdges(cube);
		LLEdge(cube);
	}

	protected static String[] LEdgemoves = {"umU","UMMu","uMU","UMUUmU","uMUUMMu","M","R","m","r","MM","RR","X","FMMfUMu","FMMfuMMU","DmdMumU","DmdMUMMu","BmbUMMu","BmbuMU",""};


	static void LEdges (Cube cube){
		int numLedge = 0;
		int move = -1;
		int edgePos = -1;
		int loop = 0;

		String currentalgorithm = "";
		String moveselection = "";

		while(numLedge != 3){

			if(cube.Uface[0][0]==cube.Uface[1][0]&&cube.Lface[0][0]==cube.Lface[0][1]){
				numLedge++;
				cube.performAlgorithm("X", false);
				currentalgorithm+="X";	


			}else{

				edgePos = getEdgePos(cube,cube.Uface[0][0],cube.Lface[1][1]);

				move = convertLEdgePos(edgePos);

				if(move == 11){
					move = convertExtraLEdgePos(edgePos);
				}

				if(move==-1){
					System.out.println(edgePos);
				}



				cube.performAlgorithm(LEdgemoves[move], false);

				currentalgorithm+=LEdgemoves[move];
				moveselection+=move+",";
				loopcounter4++;

			}

			loop++;
			if(loop>20){
				System.out.println("Error: LEdges not placed, algorithm to this point: " + currentalgorithm);
				System.out.println("Move Selection: "+moveselection);
				cube.prettyPrint();
				numLedge = 3;
			}

		}

		int loop2 = 0;

		while((cube.Lface[0][0]==cube.Lface[0][1])&&loop2<4){

			cube.performAlgorithm("X", false);
			currentalgorithm+="X";
			loop2++;
		}

		if((cube.Fface[0][0]==cube.Fface[1][0])&&(cube.Fface[0][0]==cube.Fface[2][0])&&(cube.Dface[0][0]==cube.Dface[1][0])&&(cube.Dface[0][0]==cube.Dface[2][0])&&
				(cube.Bface[0][0]==cube.Bface[1][0])&&(cube.Bface[0][0]==cube.Bface[2][0])){
			if(print)
				System.out.println("3 LEdges Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}

	}

	static int convertREdgePos(int Edge){

		switch(Edge){
		case 4 : return 0;
		case 5 : return 1;
		case 11: return 2;
		case 10: return 3;
		case 9 : return 4;
		case 0 : return 5;
		case 1 : return 5;
		case 2 : return 6;
		case 3 : return 6;
		case 12: return 7;
		case 13: return 7;
		case 14: return 6;
		case 15: return 6;
		case 16: return 6;
		case 17: return 6;
		case 22: return 8;
		case 23: return 8;
		case 8 : return 12;
		}


		return -1;
	}

	static int convertExtraREdgePos(int Edge){

		switch(Edge){
		case 2: return 9;
		case 3: return 9;
		case 14:return 10;
		case 15:return 10;
		case 16:return 11;
		case 17:return 11;
		}


		return -1;
	}

	protected static String[] REdgemoves = {"Umu","uMMU","UMu","uMUUmu","UMUUMMU","M","R","MM","m","RumUr","rumUR","RRumURR",""};

	static void REdges (Cube cube){
		int numRedge = 0;
		int move = -1;
		int edgePos = -1;
		int loop = 0;

		String currentalgorithm = "";
		String moveselection = "";

		while(numRedge != 4){


			if(cube.Uface[0][2]==cube.Uface[1][2]&&cube.Rface[0][0]==cube.Rface[0][1]){
				numRedge++;
				cube.performAlgorithm("R", false);
				currentalgorithm+="R";	

			}else{

				edgePos = getEdgePos(cube,cube.Uface[0][2],cube.Rface[1][1]);

				move = convertREdgePos(edgePos);

				if(move == 6){
					move = convertExtraREdgePos(edgePos);
				}


				if(move==-1){
					System.out.println(edgePos);
				}



				cube.performAlgorithm(REdgemoves[move], false);


				currentalgorithm+=REdgemoves[move];
				moveselection+=move+",";
loopcounter4++;
			}

			loop++;
			if(loop>15){
				System.out.println("Error: REdges not placed, algorithm to this point: " + currentalgorithm);
				System.out.println("Move Selection: "+moveselection);
				cube.prettyPrint();
				numRedge = 4;
			}

		}



		if((cube.Fface[0][2]==cube.Fface[1][2])&&(cube.Fface[0][2]==cube.Fface[2][2])&&(cube.Dface[0][2]==cube.Dface[1][2])&&(cube.Dface[0][2]==cube.Dface[2][2])&&
				(cube.Bface[0][2]==cube.Bface[1][2])&&(cube.Bface[0][2]==cube.Bface[2][2])&&(cube.Uface[0][2]==cube.Uface[1][2])&&(cube.Uface[0][2]==cube.Uface[2][2])){
			if(print)
				System.out.println("4 REdges Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}
	}

	protected static String[] LLEdgemoves = {"uMUUMu","UmUUmU","MuMUUMu","MMuMUUMu","muMUUMu","MUmUUmU","MMUmUUmU","mUmUUmU","","uMUUMumuMUUMu"};

	static int convertLLEdgePos(int Edge){

		switch(Edge){
		case 5:return 0;
		case 23:return 1;
		case 0:return 2;
		case 12:return 3;
		case 22:return 4;
		case 4:return 5;
		case 1:return 6;
		case 13:return 7;
		case 10:return 8;
		case 11:return 9;
		}


		return -1;
	}

	static void LLEdge (Cube cube){
		String currentalgorithm = "";
		int edgePos = -1;
		int move = -1;

		edgePos = getEdgePos(cube,cube.Uface[0][0],cube.Lface[1][1]); 

		move = convertLLEdgePos(edgePos);

		
		cube.performAlgorithm(LLEdgemoves[move], false);
		loopcounter4++;
		currentalgorithm+=LLEdgemoves[move];
		
		if(cube.Lface[0][0]==cube.Lface[0][1]&&cube.Uface[2][0]==cube.Uface[1][0]){
			if(print)
				System.out.println("Last LEdge Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}else{
			System.out.println("Error: REdges not placed, algorithm to this point: " + currentalgorithm);
			
			cube.prettyPrint();
			
		}

	}

	protected static String[] midgeFlipMoves = {"","mUmUmUUMUMUMUU","X","XX","x"};
	
	
	static void OrtegaMidges(Cube cube){
		loopcounter5=0;
		FlipMidges(cube);
		PlaceMidges(cube);
	}
	
	static int getMidgeState(Cube cube){
		//initialise state
		int state = 0;
		
		//check if a target edge is in place or not
		if(cube.Uface[0][1]!=cube.Uface[1][1])
			if(cube.Uface[0][1]!=opposite(cube.Uface[1][1]))
				//start to build the unique integer by using powers of 2
				state = (int) (state + Math.pow(2, 0));
		if(cube.Uface[2][1]!=cube.Uface[1][1])
			if(cube.Uface[2][1]!=opposite(cube.Uface[1][1]))
				state = (int) (state + Math.pow(2, 1));
		if(cube.Fface[2][1]!=cube.Fface[1][1])
			if(cube.Fface[2][1]!=opposite(cube.Fface[1][1]))
				state = (int) (state + Math.pow(2, 2));
		if(cube.Dface[2][1]!=cube.Dface[1][1])
			if(cube.Dface[2][1]!=opposite(cube.Dface[1][1]))
				state = (int) (state + Math.pow(2, 3));
		
		return state;
	}
	
	static int convertMidgeState(int state){

		//convert the unique integer to an index
		switch(state){
		case 0:return 0;
		case 3:return 1;
		case 6:return 2;
		case 12:return 3;
		case 9:return 4;
		case 15:return 1;
		case 5:return 1;
		
		}

		//if there is no match then return the index for the move to rotate the whole cube
		return 4;
	}

	static void FlipMidges (Cube cube){
		int state = -1 ;
		String currentalgorithm = "";
		String moveselection = "";
		int move = -1;
		int loop = 0;
		
		while(state != 0){
			state = getMidgeState(cube);
			move = convertMidgeState(state);
			
			cube.performAlgorithm(midgeFlipMoves[move], false);
			currentalgorithm += midgeFlipMoves[move];
			moveselection+=move+",";
			loopcounter5++;
			
			loop++;
			if(loop>12){
				System.out.println("Error: Midges not flipped, algorithm to this point: " + currentalgorithm);
				System.out.println("Move Selection: "+moveselection);
				cube.prettyPrint();
				
				state = 0;
			}
		}
		state = getMidgeState(cube);
		if(state==0){
			if(print)
				System.out.println("Midges Flipped... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}
	}

	protected static String[] midgePlaceMoves = {"","UUMUUm","UUmUUM","UUMMUUMM","ZmmzMZmmzM","X"};
	
	static int getMidgePlaceState(Cube cube){
		if(cube.Uface[0][1]==cube.Uface[1][1]&&cube.Uface[2][1]==cube.Uface[1][1]&&cube.Fface[0][1]==cube.Fface[1][1]&&cube.Bface[2][1]==cube.Bface[1][1]){
			return 0;
		}
		if(cube.Uface[0][1]==cube.Uface[1][1]&&cube.Uface[2][1]==opposite(cube.Uface[1][1])&&cube.Fface[0][1]==opposite(cube.Fface[1][1])&&cube.Bface[2][1]==opposite(cube.Bface[1][1])){
			return 1;
		}
		if(cube.Uface[0][1]==opposite(cube.Uface[1][1])&&cube.Uface[2][1]==cube.Uface[1][1]&&cube.Fface[0][1]==opposite(cube.Fface[1][1])&&cube.Bface[2][1]==opposite(cube.Bface[1][1])){
			return 2;
		}
		if(cube.Uface[0][1]==cube.Uface[1][1]&&cube.Uface[2][1]==cube.Uface[1][1]&&cube.Fface[0][1]==opposite(cube.Fface[1][1])&&cube.Bface[2][1]==opposite(cube.Bface[1][1])){
			return 3;
		}
		if(cube.Uface[0][1]==opposite(cube.Uface[1][1])&&cube.Uface[2][1]==opposite(cube.Uface[1][1])&&cube.Fface[0][1]==opposite(cube.Fface[1][1])&&cube.Bface[2][1]==opposite(cube.Bface[1][1])){
			return 4;
		}
		
		return 5;
	}
	static void PlaceMidges (Cube cube){
		int state = -1;
		String currentalgorithm = "";
		String moveselection = "";
		int loop = 0;
		
		while(state != 0){
			state = getMidgePlaceState(cube);
			
			cube.performAlgorithm(midgePlaceMoves[state], false);
			currentalgorithm += midgePlaceMoves[state];
			moveselection += state+",";
			loop++;
			loopcounter5++;
			if(loop>10){
				System.out.println("Error: Midges not placed, algorithm to this point: " + currentalgorithm);
				System.out.println("Move Selection: "+moveselection);
				cube.prettyPrint();
				
				state = 0;
			}
			
		}
		state = getMidgePlaceState(cube);
		if(state==0){
			if(print)
				System.out.println("Midges Placed... " + currentalgorithm);
			algorithm = algorithm + currentalgorithm;
		}
	}
	
	static void OrtegaFinalAdjustments(Cube cube){
		String currentalgorithm = "";
		loopcounter6=0;
		while(cube.Fface[0][0]!=cube.Fface[1][1]){
			cube.performAlgorithm("L", false);
			currentalgorithm+="L";
			loopcounter6++;
		}
		while(cube.Fface[0][2]!=cube.Fface[1][1]){
			cube.performAlgorithm("R", false);
			currentalgorithm+="R";
			loopcounter6++;
		}
		if(cube.solved())
			algorithm +=currentalgorithm;
		else{
			System.out.println("Error");
			cube.prettyPrint();
		}
	}

	static void Ortega(Cube cube){
		algorithm = "";
		if(print)
			System.out.println("Solving...");

		OTC(cube);
		OBC(cube);
		PAC(cube);
		OrtegaEdges(cube);
		OrtegaMidges(cube);
		OrtegaFinalAdjustments(cube);
		if(print)
			System.out.println("Solution algorithm: "+algorithm);

	}

}
