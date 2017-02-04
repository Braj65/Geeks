package geeks.DP.DP;

public class Partitionproblem {
	public static void main(String[] args) {
		int[] inArr={3, 1, 5, 9, 12};
		System.out.println(findPartition(inArr, inArr.length));
	}
	
	public static boolean findPartition(int[] in, int n){
		int sum=0;
		
		for(int x:in){
			sum=sum+x;
		}
		
		if(sum%2!=0)
			return false;
		
		boolean[][] dp=new boolean[n+1][sum/2+1];
		
		for(int i=0;i<n+1;i++){
			dp[i][0]=true;
		}
		
		for(int i=1;i<=sum/2;i++){
			dp[0][i]=false;
		}
		
		for(int i=1;i<n+1;i++){
			for(int j=1;j<=sum/2;j++){
				if(j<in[i-1])
					dp[i][j]=dp[i-1][j];
				else{
					dp[i][j]=dp[i-1][j]||dp[i-1][j-in[i-1]];
				}
			}
			if(dp[i][sum/2]==true)
				return true;
		}
		return false;
		
	}
}
