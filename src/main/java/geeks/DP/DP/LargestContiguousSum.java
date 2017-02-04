package geeks.DP.DP;

public class LargestContiguousSum {
	
	public static void main(String[] args) {
		int[] inArr={-2, -3, 4, -1, -2, 1, 5, -3};
		contSum(inArr);
	}
	
	public static void contSum(int[] in){
		int maxSum=in[0];
		int totalSum=in[0]; //start of the contigous subarray
		for(int i=1;i<in.length;i++){
			totalSum=totalSum+in[i];
			
			if(maxSum<totalSum && totalSum<in[i]){
				totalSum=in[i];
			}else if(maxSum<totalSum){
				maxSum=totalSum;
			}
		}
	}

}
