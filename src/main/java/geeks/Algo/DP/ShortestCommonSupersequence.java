package geeks.Algo.DP;

public class ShortestCommonSupersequence {
	
	public static void main(String[] args) {
		char[] X={'A','G','G','T','A','B'};
		char[] Y={'G','X','T','X','Y','A','B'};
		
		/*char[] X={'G','E','E','K'};
		char[] Y={'E','K','E'};*/
		
		System.out.println(scs(X, Y, X.length, Y.length));
	}
	
	public static int scs(char[] X, char[] Y, int x, int y){
		
		int[][] dp=new int[x+1][y+1];
		
		for(int i=0;i<=y;i++){
			dp[0][i]=i;
		}
		for(int i=0;i<=x;i++){
			dp[i][0]=i;
		}
		
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				if(X[i-1]==Y[j-1]){
					dp[i][j]=1+dp[i-1][j-1];
				}else{
					dp[i][j]=1+Math.min(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[x][y];
	}

}
