package geeks.Algo.DP;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String str1= "abacdc";
		char[] str=str1.toCharArray();
		System.out.println(minPalPartion(str));
	}
	
	public static int minPalPartion(char[] str){
		int n=str.length;
		
		int[][] dp=new int[n][n];
		boolean[][] P=new boolean[n][n];
		for(int i=0;i<n;i++){
			P[i][i]=true;
		}
		
		for (int L=2; L<=n; L++)
	    {
	        // For substring of length L, set different possible starting indexes
	        for (int i=0; i<n-L+1; i++)
	        {
	            int j = i+L-1; // Set ending index
	  
	            // If L is 2, then we just need to compare two characters. Else
	            // need to check two corner characters and value of P[i+1][j-1]
	            if (L == 2)
	                P[i][j] = (str[i] == str[j]);
	            else
	                P[i][j] = (str[i] == str[j]) && P[i+1][j-1];
	  
	            // IF str[i..j] is palindrome, then C[i][j] is 0
	            if (P[i][j] == true)
	                dp[i][j] = 0;
	            else
	            {
	                // Make a cut at every possible localtion starting from i to j,
	                // and get the minimum cost cut.
	                dp[i][j] = Integer.MAX_VALUE;
	                for (int k=i; k<=j-1; k++)
	                    dp[i][j] = Math.min(dp[i][j], dp[i][k] +dp[k+1][j]+1);
	            }
	        }
	    }
		
		return dp[0][n-1];
	}

}
