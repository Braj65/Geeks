package geeks.DP.Recurse;

public class LongestPalindromeSubstring_ksackAPp {
	public static void main(String[] args) {
//		String str="mlrlwggfggy";
//		String str="mlrly";
		String str="mylirilwgeeksfskeegmy";
		char[] inArr=str.toCharArray();
		System.out.println(palSubString(inArr, 0, inArr.length-1));
	}
	
	public static String palSubString(char[] in, int start, int end){
		if(start==end)
			return new String(in, start, 1);
		if(in[start]==in[end]){
//			return 2+palSubString(in, start+1, end-1);	//editorial sol
			if(checkPalin(in, start+1, end-1)){
				return new String(in, start, end-start+1);
			}
		}
			
		int max=Integer.MIN_VALUE;
		String a=palSubString(in, start+1, end);
		String b=palSubString(in, start, end-1);
		if(a.length()>b.length())
			return a;
		else
			return b;
//		return Math.max(palSubString(in, start+1, end),palSubString(in, start, end-1));
	}
	
	public static boolean checkPalin(char[] in, int start, int end){
		if(start==end){
			return true;
		}
		if(end-start==1 && in[start]==in[end])
			return true;
		else if(in[start]==in[end])
			return checkPalin(in, start+1, end-1);
		else
			return false;
	}

}
