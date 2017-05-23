package geeks.Algo.DP;

public class LongestPalindromeSubstring_mtrixApp {
	
	public static void main(String[] args) {
//		String str="mylirilwgeeksfskeegmy";
		String str="mlrly";
		char[] inArr=str.toCharArray();
		System.out.println(palSubString(inArr));
	}
	
	//Works on kind of matrix multiplication algo. First it fills up "true" for single alphabets
	//Then finds plain in double alphabets combination. Then when it comes to three alphabets
	//combi then it checks whether the first and third alphabet are equal. If equal then check that
	//the single alphabet between them is equal or not. Like- dp[1][3]=in[1]==in[3] && dp[2][2].
	//Same goes for 4 alphabet combi. in[1]==in[4] && dp[2][3]. This is th reason we are filling
	//single and double alphabet combi first.
	public static int palSubString(char[] in){
		int len=in.length;
		boolean[][] dp=new boolean[len][len];
		
		for(int i=0;i<len;i++){
			dp[i][i]=true;
		}
		
		int start = 0;
		int maxLength=1;
	    for (int i = 0; i < len-1; ++i)
	    {
	        if (in[i] == in[i+1])
	        {
	            dp[i][i+1] = true;
	            start = i;
	            maxLength = 2;
	        }
	    }
		
		for(int j=3;j<=len;j++){			
			for(int i=0;i<len-j+1;i++){
				int k=j+i-1;;
				if(dp[i+1][k-1] && in[i]==in[k]){
					dp[i][k]=true;
					if(j>maxLength){
						start=i;
						maxLength=j;
					}
				}
			}
		}
		return maxLength;
	}

}
