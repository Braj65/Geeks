package geeks.DP.DP;

public class MaxSumIncreasingSubsequence {
	public static void main(String[] args) {
		int[] inArr={1,14,5,7,6,12};
		System.out.println(maxSeq(inArr));
		System.out.println(maxSumIS(inArr, inArr.length));
	}
	
	public static int maxSeq(int[] in){
		int len=in.length;
		
		int[] dp=new int[len];
		
		for(int i=1;i<len;i++){
			int temp=in[i];
			int prevMin=Integer.MIN_VALUE;
			for(int j=0;j<i;j++){
				if(in[i]>in[j] && in[j]>prevMin){
					prevMin=in[j];
					dp[i]=temp;
					temp=dp[i]+in[j];
				}
			}
			if(temp>dp[i-1])
				dp[i]=temp;
			else
				dp[i]=dp[i-1];
		}
		return dp[len-1];
	}
	
	public static int maxSumIS( int arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];
 
        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];
 
        /* Compute maximum sum values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] &&
                     msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];
 
        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];
 
        return max;
    }

}
