package geeks.Algo.DP;
//http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
public class LongPalinSubsequence {
	public static void main(String[] args) {
		String x="ABCDBBC";
		int len=x.length();
		char[] y=x.toCharArray();
		System.out.println(longPalSub(y, 0, y.length-1));
	}
	
	public static int longPalSub(char[] x, int start ,int end){
		int[][] dp=new int[end+1][end+1];
		
		for(int i=0;i<=end;i++){
			dp[i][i]=1;
		}
		
		for(int j=1;j<=end;j++){
			int k=j;
			for(int i=0;i<=end-j;i++){
				if(x[i]==x[k] && k==2)
					dp[i][k]=2;
				if(x[i]==x[k])
					dp[i][k]=2+dp[i+1][k-1];
				else
					dp[i][k]=Math.max(dp[i][k-1], dp[i+1][k]);
				++k;
			}
		}
		return dp[0][end];
	}

}
