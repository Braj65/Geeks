package geeks.DP.DP;

public class EditDistance {
	
	public static void main(String[] args) {
		String str1="sunday";
		String str2="saturday";
		int x=editDist(str1, str2, str1.length(), str2.length());
		System.out.println(x);
	}
	
	public static int editDist(String str1, String str2, int m, int n){
		
		int[][] dp=new int[m+1][n+1];
		int res=0;
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else{
					if(str1.charAt(i-1)==str2.charAt(j-1)){
						dp[i][j]=dp[i-1][j-1];
					}else{
						dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
					}
				}
			}
		}
		return dp[m][n];		
	}
	
	public static int min(int x, int y, int z){
		if(x<y && x<z)
			return x;
		else if(y<x && y<z)
			return y;
		else
			return z;
	}

}
