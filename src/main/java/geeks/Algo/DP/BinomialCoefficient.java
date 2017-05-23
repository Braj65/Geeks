package geeks.Algo.DP;

public class BinomialCoefficient {
	public static void main(String[] args) {
		int n=4;
		int k=2;
		System.out.println(coeff(4,2));
	}
	
	public static int coeff(int n, int k){
		int[][] dp=new int[k+1][n+1];
		
		for(int i=0;i<=n;i++){
			dp[0][i]=1;
		}
		
		for(int i=1;i<=k;i++){
			for(int j=0;j<=n;j++){
				if(i>j)
					dp[i][j]=0;
				else{
					dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
				}
			}
		}
		return dp[k][n];
	}
}
