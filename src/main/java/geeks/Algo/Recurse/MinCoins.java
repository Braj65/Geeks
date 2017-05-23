package geeks.Algo.Recurse;

public class MinCoins {
	
	public static void main(String[] args) {
		int[] in={25, 10, 5};
		int tar=30;
		System.out.println(minCoins(in, in.length,tar));
	}
	
	public static int minCoins(int[] coins, int len, int tar){
		if(tar==0)
			return 0;
		
		int res=Integer.MAX_VALUE;
		
		for(int i=0;i<len;i++){
			if(coins[i]<=tar){
				int sub_res=minCoins(coins, len, tar-coins[i]);
				
				if(sub_res!=Integer.MAX_VALUE && sub_res+1<res)
					res=sub_res+1;
			}
		}
		return res;
	}

}
