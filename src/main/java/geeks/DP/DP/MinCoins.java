package geeks.DP.DP;

public class MinCoins {
	public static void main(String[] args) {
		int[] in={25, 10, 5};
		int tar=30;
		System.out.println(minCoins(in, in.length,tar));
	}
	
	public static int minCoins(int[] coins, int len, int tar){
		int[] dp=new int[tar+1];
		dp[0]=0;
		
		for(int i=1;i<len;i++)
			dp[i]=Integer.MAX_VALUE;
		
		for(int i=1;i<=tar;i++){
			
			for(int j=0;j<len;j++){
				if(coins[j]<=i){
					int sub_res=dp[i-coins[j]];
					if(sub_res!=Integer.MAX_VALUE && sub_res+1<dp[i])
						dp[i]=1+sub_res;
				}
			}
		}
		return dp[tar];
	}

}
