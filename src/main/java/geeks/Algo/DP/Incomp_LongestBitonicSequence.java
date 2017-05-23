package geeks.Algo.DP;

public class Incomp_LongestBitonicSequence {
	static int max_ref;
	public static void main(String[] args) {
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		
	}
	
	public static int lbs(int[] in, int n){
		
		if(n==1)
			return 1;
		int res=0;
		int max_ending_here=1;
		for(int i=1;i<n;i++){
			res=lbs(in, i);
			if(in[i]<in[n-1] && res+1>max_ending_here){
				max_ending_here=res+1;
			}
		}
		if (max_ref < max_ending_here)
	           max_ref = max_ending_here;	 
	        // Return length of LIS ending with arr[n-1]
	    return max_ending_here;
	}

}
