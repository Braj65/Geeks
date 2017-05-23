package geeks.Algo.DP;

//http://www.cs.uml.edu/~kdaniels/courses/ALG_503_F12/DynamicRodCutting.pdf
public class CuttingRod_OneWay {
	public static void main(String[] args) {
		int val[]={1, 5, 8, 9, 10, 17, 17, 20};
		
		System.out.println(cutRod(val, 8));
	}
	
	public static int cutRod(int[] val, int tarWt){
		int[][] dp=new int[tarWt+1][tarWt+1];
		
		for(int i=1;i<=tarWt;i++){
			dp[0][i]=val[i-1];
			dp[i][0]=val[i-1];
		}
		int res=0;
		for(int i=1;i<=tarWt;i++){
			for(int j=1;j<=tarWt;j++){
				if(i==j && j==1)
					dp[i][j]=val[0];
				else if(j>i){
					dp[i][j]=dp[i][j-1];
				}else{
					res=dp[i-j][j]+dp[j][j];
					if(res>dp[i][j-1])
						dp[i][j]=res;
					else
						dp[i][j]=dp[i][j-1];
				}
			}
		}
		return dp[tarWt][tarWt];
	}

}
