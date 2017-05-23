package geeks.Algo.Recurse;

public class LCS {
	
	public static void main(String[] args) {
		char[] X={'A','G','G','T','A','B'};
		char[] Y={'G','X','T','X','Y','A','B'};
		
		System.out.println(lcs(X, Y, X.length-1, Y.length-1, 0));
	}
	
	public static int lcs(char[] X, char[] Y, int m, int n, int tots){
		if(m<0 || n<0){
			return tots;
		}
		if(X[m]==Y[n]){
			return 1+lcs(X, Y, m-1, n-1, tots);
		}else{
			return Math.max(lcs(X, Y, m-1, n, tots), lcs(X, Y, m, n-1, tots));
		}
	}

}
