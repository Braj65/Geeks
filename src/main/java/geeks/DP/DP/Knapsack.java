package geeks.DP.DP;

public class Knapsack {
	public static void main(String[] args) {
		int[] val={60, 100, 120};
		int[] wt={10,20,30};
		int tarWt=50;
		System.out.println(knap(val, wt, 0, tarWt));
	}
	
	public static int knap(int[] val, int[] wt, int q, int tarWt ){
		int[][] dp=new int[val.length+1][tarWt+1];
		
		for(int r=0;r<=tarWt;r++){
			dp[0][r]=0;
		}
		
		for(int i=1;i<=val.length;i++){
			for(int j=0;j<=tarWt;j++){
				if(j<wt[i-1]){
					dp[i][j]=dp[i-1][j];
				}else{
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j-wt[i-1]]);
				}
			}
		}
		return dp[val.length][tarWt];
	}
}
