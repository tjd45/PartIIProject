package uk.ac.cam.tjd45.partiiproj;

public class SolutionsAnalytics {
	
	public static void main(String[] args){
		String alg = "";
		int longestCFOP = 0;
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		
		int longestCFOPcross = 0;
		for(String s : Solutions.crossmoves){
			if (s.length() > longestCFOPcross){
				longestCFOPcross = s.length();
				s1 = s;
				
			}
		}
		alg += s1 + s1 + s1 + s1;
		int[] cmlengths = new int[s1.length()+1];
		
		for(String s : Solutions.crossmoves){
			cmlengths[s.length()]++;
		}
		
		for(int i = 0; i<cmlengths.length;i++){
			System.out.println(i +" moves: "+ cmlengths[i]);
		}
		
		
		longestCFOPcross*=4;
	
		int longestCFOPcorners = 0;
		for(String s : Solutions.cornermoves){
			if (s.length() > longestCFOPcorners){
				longestCFOPcorners = s.length();
				s2 = s;
			}
		}
		
		alg += s2+s2+s2+s2;
		longestCFOPcorners *=4;
	
		int longestCFOPF2l = 0;
		for(String s : Solutions.FB2lmoves){
			if (s.length() > longestCFOPF2l){
				longestCFOPF2l = s.length();
				s3 = s;
			}
		}
		alg += s3 + s3 + s3 + s3;
		longestCFOPF2l*=4;
		
		int longesttopcross = 0;
		String longesttopcrossalg = "FRUruRUrufUFRUruf";
		longesttopcross = longesttopcrossalg.length();
		alg += longesttopcrossalg;
		
		int longesttopcrossperm = 0;
		String longesttopcrosspermalg = "RUrURUUrURUrURUUrURUrURUUrU";
		longesttopcrossperm = longesttopcrosspermalg.length();
		alg += longesttopcrosspermalg;
		
		int longesttopcornerperm = 0;
		String longesttopcornerpermalg = "URulUruLURulUruLURulUruL";
		longesttopcornerperm = longesttopcornerpermalg.length();
		alg += longesttopcornerpermalg;
		
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
		
		s2 ="";
		for(String[] As : Solutions.F2lmoves){
			for(String s : As){
				if (s.length() > s2.length()){
					s2 = s;
					
				}
			}
			
		}
		Falg += s2 + s2 + s2 + s2 + "luLUluLUluLUluLU";
		
		s3 = "";
		for(String s : Solutions.OLLmoves){
			if (s.length() > s3.length()){
				s3 = s;	
			}
		}
		Falg += s3;
		
		s4 = "";
		for(String s : Solutions.PLLmoves){
			if (s.length() > s4.length()){
				s4 = s;	
			}
		}
		Falg += s4;
		
		System.out.println("Length of longest Fridrich algorithm: "+ Falg.length());
		System.out.println("Length of longest CFOP algorithm: " + alg.length());
		
	}

}
