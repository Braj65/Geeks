package geeks.DP.DP;

public class LCS_DP {
	
	public static void main(String[] args) {
		char[] X={'A','G','G','T','A','B'};
		char[] Y={'G','X','T','X','Y','A','B'};
		
		int m=X.length-1;
		int n=Y.length-1;
		int[][] l=lcs(X, Y, m, n);
		printSequence(l, X, Y);
	}
	
	public static int[][] lcs(char[] X, char[] Y, int m, int n){
		int[][] L=new int[m+1][n+1];
		String[][] S=new String[m+1][n+1];
		
		
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0 || j==0){
					L[i][j]=0;
					S[i][j]="";
				}else if(X[i-1]==Y[j-1]){
					S[i][j]="";
					L[i][j]=L[i-1][j-1]+1;
					S[i][j]=S[i-1][j-1]+""+X[i-1];
				}else{
					S[i][j]="";
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
					if(S[i-1][j].length()>S[i][j-1].length())
						S[i][j]=S[i-1][j];
					else
						S[i][j]=S[i][j-1];
				}
			}
		}
		
		return L;
	}
	
	public static void printSequence(int[][] l, char[] X, char[] Y){
		int m=l[0].length-1;
		int n=l.length-1;
		String c="";
		
		while(m>0 && n>0){
			if(Y[m]==X[n]){
				c=c+Y[m];
				m--;
				n--;
			}else{
				if(l[n-1][m]>l[n][m-1])
					n--;
				else
					m--;
			}
		}
		System.out.println(c);
	}
	

}



















