package geeks.DP.Recurse;

public class MaxProfitShareTwice {
	
	static int max_ref;
	public static void main(String[] args) {
		int[] price = {10, 22, 5, 75, 65, 80};
		System.out.println(maxProfit(price, price.length));
	}
	
	public static int maxProfit(int[] in, int n){
		if(n==1)
			return 1;
		
		int res=0, max=1;
		for(int i=1;i<n;i++){
			res=maxProfit(in, i);
			
			if(in[n-1]>in[i-1] && res>max){
				max=res;
			}
		}
		if(max_ref<max)
			max_ref=max;
		
		return max;
	}

}
