package geeks.Algo.DP;

public class MinJumpsEnd_Self {
	public static void main(String[] args) {
//		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(inArr));
	}
	
	public static int minJumps(int[] in){
		int n=in.length;
		int[][] dp=new int[in.length][in.length];
		
		for(int i=0;i<n;i++){
			dp[i][i]=0;
			dp[0][i]=0;
		}
		
		/*for(int j=n;j>0;j--){
			for(int i=n;i>0;i--){
				if(j>i+in[i]){
					continue;
				}else{
					dp[i][j]=1;
				}
			}
		}*/
		
		for(int i=1;i<n;i++){
			for(int j=2;j<n;j++){
				if(j>i+in[i]){
					continue;
				}else{
					dp[i][j]=1+dp[i-1][i];
				}
			}
			if(dp[i][n-1]!=0)
				return dp[i][n-1];
		}
		return 0;
	}

}
