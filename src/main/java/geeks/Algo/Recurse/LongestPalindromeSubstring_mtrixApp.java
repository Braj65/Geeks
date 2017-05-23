package geeks.Algo.Recurse;

public class LongestPalindromeSubstring_mtrixApp {
	
	public static void main(String[] args) {
		String str="mylirilwgeeksfskeegmy";
//		String str="mlrly";
		char[] inArr=str.toCharArray();
		System.out.println(palSubString(inArr, 0, inArr.length-1));
	}
	
	public static String palSubString(char[] in, int start, int end){
		
		if(start==end)
			return new String(in, start, 1);
		if(in[start]==in[end]){
			if(checkPalin(in, start+1, end-1)){
				return new String(in, start, end-start+1);
			}
//			return 2+palSubString(in, start+1, end-1);
		}
		int len=0;
		int max=Integer.MIN_VALUE;
		String maxStr="";
		for(int k=start;k<end;k++){
			String a=palSubString(in, start, k);
			String b=palSubString(in, k+1, end);
			
			if(a.length()>b.length() && a.length()>max){
				max=a.length();
				maxStr=a;
			}else if(b.length()>max){
				max=b.length();
				maxStr=b;
			}
			/*len=Math.max(a.length(),b.length());
			if(len>max)
				max=len;*/
		}
		return maxStr;
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
