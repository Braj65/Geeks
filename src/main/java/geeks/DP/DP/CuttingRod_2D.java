package geeks.DP.DP;

public class CuttingRod_2D {
	public static void main(String[] args) {
		int val[]={1, 5, 8, 9, 10, 17, 17, 20};
		int wt[]={0,1,2,3,4,5,6,7,8};
		
//		cutRod(wt, val, 8, 8);
		
		System.out.println(cutRod(val, 4));
	}
	
	public static int cutRod(int[] val, int pos){
		int[][] dp=new int[pos+1][pos+1];
		
		for(int i=0;i<=pos;i++){
			dp[0][i]=0;
			dp[i][0]=0;
		}
		
		int min=Integer.MIN_VALUE;
		int res=0;
		for(int i=1;i<=pos;i++){
			for(int j=1;j<=j;j++){
				if(i>=j)
					dp[i][j]=val[j-1]+dp[i-j][i-j];
				else
					dp[i][j]=dp[i][j-1];
				
			}
		}
		return dp[pos][pos];
	}

}
