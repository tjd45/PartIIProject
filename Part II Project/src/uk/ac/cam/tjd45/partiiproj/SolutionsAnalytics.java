package uk.ac.cam.tjd45.partiiproj;

public class SolutionsAnalytics {

	public static void main(String[] args){
		int len = 0;
		String alg = "";
		int longestCFOP = 0;
		String s1 = "";
		String[] topCrossMoves = {"FRUruf","UFRUruf","FRUruRUrufUFRUruf","FRUruRUruf",
				"uFRUruRUruf","FRUrufUFRUruf","UFRUruRUruf"};
		
		String[] tcPermMoves = {"U","RUrURUUr","BUbUBUUb","U","FUfUFUUf","U","RUrURUUr","LUlULUUl",
				"RUrURUUrU","U","U"};
		
		String[] tcorPermMoves = {"URulUruL","UFubUfuB","URulUruL","URulUruL","UBufUbuF","URulUruL",
				"URulUruL","ULurUluR","URulUruL","URulUruL","URulUruL"};

		String[] tcorOrMoves = {};
		
		int[][] CFOPlengths = new int[7][];

		
		int longestCFOPcross = 0;
		for(String s : Solutions.crossmoves){
			if (s.length() > longestCFOPcross){
				longestCFOPcross = s.length();
				s1 = s;

			}
		}
		alg += s1 + s1 + s1 + s1;
		CFOPlengths[0] = new int[s1.length()+1];

		for(String s : Solutions.crossmoves){
			CFOPlengths[0][s.length()]++;
		}


		longestCFOPcross*=4;

		int longestCFOPcorners = 0;
		for(String s : Solutions.cornermoves){
			if (s.length() > longestCFOPcorners){
				longestCFOPcorners = s.length();
				s1 = s;
			}
		}

		CFOPlengths[1] = new int[s1.length()+1];

		for(String s : Solutions.cornermoves){
			CFOPlengths[1][s.length()]++;
		}


		alg += s1+s1+s1+s1;
		longestCFOPcorners *=4;

		int longestCFOPF2l = 0;
		for(String s : Solutions.FB2lmoves){
			if (s.length() > longestCFOPF2l){
				longestCFOPF2l = s.length();
				s1 = s;
			}
		}
		
		CFOPlengths[2] = new int[s1.length()+1];

		for(String s : Solutions.FB2lmoves){
			CFOPlengths[2][s.length()]++;
		}
		
		alg += s1 + s1 + s1 + s1;
		longestCFOPF2l*=4;

		
		int longesttopcross = 0;
		String longesttopcrossalg = "FRUruRUrufUFRUruf";
		longesttopcross = longesttopcrossalg.length();
		alg += longesttopcrossalg;
		
		len = 0;
		for(String s : topCrossMoves){
			if (s.length()>len){
				len = s.length();
				s1 = s;
			}
		}
		
		CFOPlengths[3] = new int[len+1];
		
		for(String s : topCrossMoves){
			CFOPlengths[3][s.length()]++;
		}

		int longesttopcrossperm = 0;
		String longesttopcrosspermalg = "RUrURUUrURUrURUUrURUrURUUrU";
		longesttopcrossperm = longesttopcrosspermalg.length();
		alg += longesttopcrosspermalg;
		
		len = 0;
		for(String s : tcPermMoves){
			if (s.length()>len){
				len = s.length();
				s1 = s;
			}
		}
		
		CFOPlengths[4] = new int[len+1];
		
		for(String s : tcPermMoves){
			CFOPlengths[4][s.length()]++;
		}

		int longesttopcornerperm = 0;
		String longesttopcornerpermalg = "URulUruLURulUruLURulUruL";
		longesttopcornerperm = longesttopcornerpermalg.length();
		alg += longesttopcornerpermalg;
		
		len = 0;
		for(String s : tcorPermMoves){
			if (s.length()>len){
				len = s.length();
				s1 = s;
			}
		}
		
		CFOPlengths[5] = new int[len+1];
		
		for(String s : tcorPermMoves){
			CFOPlengths[5][s.length()]++;
		}


		int longesttopcornerorient = 0;
		String longesttopcornerorientalg = "URulUruLURulUruLURulUruL";
		longesttopcornerorient = longesttopcornerorientalg.length();
		alg += longesttopcornerorientalg;
		
		
		

		longestCFOP = longestCFOPcross + longestCFOPcorners + longestCFOPF2l + longesttopcross + longesttopcrossperm
				+longesttopcornerperm+longesttopcornerorient;

		String Falg = "";
		s1="";
		for(String s : Solutions.crossmoves){
			if (s.length() > s1.length()){
				s1 = s;	
			}
		}
		Falg += s1 + s1 + s1 + s1;

		s1 ="";
		for(String[] As : Solutions.F2lmoves){
			for(String s : As){
				if (s.length() > s1.length()){
					s1 = s;

				}
			}

		}
		Falg += s1 + s1 + s1 + s1 + "luLUluLUluLUluLU";

		s1 = "";
		for(String s : Solutions.OLLmoves){
			if (s.length() > s1.length()){
				s1 = s;	
			}
		}
		Falg += s1;

		s1 = "";
		for(String s : Solutions.PLLmoves){
			if (s.length() > s1.length()){
				s1 = s;	
			}
		}
		Falg += s1;

		for(int i = 0; i<6;i++){


			for(int j = 0; j<CFOPlengths[i].length;j++){
				System.out.println(j +" moves: "+ CFOPlengths[i][j]);
			}
		}

		System.out.println("Length of longest Fridrich algorithm: "+ Falg.length());
		System.out.println("Length of longest CFOP algorithm: " + alg.length());

	}

}
