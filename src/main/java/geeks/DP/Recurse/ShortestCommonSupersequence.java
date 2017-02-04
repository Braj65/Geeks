package geeks.DP.Recurse;

public class ShortestCommonSupersequence {
	
	public static void main(String[] args) {
		char[] X={'A','G','G','T','A','B'};
		char[] Y={'G','X','T','X','Y','A','B'};
		
		System.out.println(scs(X, Y, X.length-1, Y.length-1, 0));
		System.out.println(scsAlt(X, Y, X.length, Y.length, 0));
	}
	
	public static int scs(char[] X, char[] Y, int x, int y, int tots){
		int comSub=lcs(X, Y, x, y, tots);
		return x+1+y+1-comSub;
	}
	
	public static int lcs(char[] X, char[] Y, int x, int y, int tots){
		if(x<0 || y<0){
			return tots;
		}
		
		if(X[x]==Y[y])
			return 1+lcs(X, Y, x-1, y-1, tots);
		else
			return Math.max(lcs(X, Y, x-1, y, tots), lcs(X, Y, x, y-1, tots));
	}
	
	//Below method accomplishes the same as above but in a single method. It is derived from above
	//It is finding the minimum length of chars which are uncommon in two strings.
	//For every common char it just adds 1. Removes it from both arrays. Takes the next two.
	//then follows the same as for LCS except addition of 1 for every non-common and minimum of
	//uncommon length
	public static int scsAlt(char[] X, char[] Y, int x, int y, int tots){
		if(x==0)
			return y;
		if(y==0)
			return x;
		
		if(X[x-1]==Y[y-1])
			return 1+scsAlt(X, Y, x-1, y-1, tots);
		else{
			return 1+Math.min(scsAlt(X, Y, x-1, y, tots), scsAlt(X, Y, x, y-1, tots));
		}
		
	}

}
