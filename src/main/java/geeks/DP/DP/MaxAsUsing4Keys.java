package geeks.DP.DP;

public class MaxAsUsing4Keys {
	
	public static void main(String[] args) {
		System.out.println(findOptimal(11));
	}
	
	public static int findOptimal(int n){
		int[] dp=new int[n+1];
		
		int max=0;
		int curr=0;
		for(int i=1;i<=6;i++)
			dp[i]=i;
		for(int i=7;i<=n;i++){
			for(int j=1;j<=i-3;j++){
				curr=(i-j-1)*dp[j];
				if(curr>max){
					max=curr;
				}
			}
			dp[i]=max;
		}
		return max;
	}

}
