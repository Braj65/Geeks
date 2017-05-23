package geeks.Algo.DP;

public class NonDecreasingNumbers {
	public static void main(String[] args) {
		int n=2;
		System.out.println(countNonDecreasing(2, 9));
	}
	
	public static int countNonDecreasing(int n, int d){
		int[][] dp=new int[n+1][d+1];
		
		for(int i=0;i<d+1;i++){
			dp[0][i]=1;
		}
		
		for(int i=1;i<=n;i++){
			dp[i][0]=1;
			for(int j=1;j<d+1;j++){
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
			}
		}
		return dp[n][d];		
	}

}
