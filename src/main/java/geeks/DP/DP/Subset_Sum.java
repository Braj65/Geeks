package geeks.DP.DP;

public class Subset_Sum {
	public static void main(String[] args) {
		int[] inArr={3,34,4,5};
		int sum=9;
		System.out.println(isSubsetSum(inArr, inArr.length, sum));
	}
	
	public static boolean isSubsetSum(int[] in, int n, int sum){
		boolean[][] dp=new boolean[n+1][sum+1];
		
		for(int i=0;i<=sum;i++)
			dp[0][i]=false;
		for(int j=0;j<n;j++)
			dp[j][0]=true;
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(j>=in[i-1]){
					dp[i][j]=dp[i-1][j] || dp[i-1][j-in[i-1]];
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}

}
