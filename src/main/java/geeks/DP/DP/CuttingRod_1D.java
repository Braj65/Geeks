package geeks.DP.DP;

public class CuttingRod_1D {
	public static void main(String[] args) {
		int val[]={3, 5, 8, 9, 10, 17, 17, 20};
		int wt[]={0,1,2,3,4,5,6,7,8};
		
//		cutRod(wt, val, 8, 8);
		
		System.out.println(cutRod(val, 4));
	}
	
	public static int cutRod(int[] val, int pos){
		int[] dp=new int[pos+1];
		dp[0]=0;
		int res=0;
		for(int j=1;j<=pos;j++){
			dp[j]=Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				res=val[i-1]+dp[j-i];
				if(res>dp[j])
					dp[j]=res;
			}
		}
		return dp[pos];
	}

}
