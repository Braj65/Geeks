package geeks.Algo.DP;

public class MatrixChain {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3 };
		int n = arr.length;
		System.out.println(matrixChain(arr, n));
	}
	
	public static int matrixChain(int[] arr, int size){
		int val=0;
		int[][] dp=new int[size][size];
		
		for(int i=0;i<size;i++){
			dp[i][i]=0;
		}
		
		for(int j=2;j<size;j++){
			int l=j;
			for(int i=1;i<size-j+1;i++){
				dp[i][l]=Integer.MAX_VALUE;
				for(int k=i;k<l;k++){
					val=dp[i][k]+dp[k+1][l]+arr[i-1]*arr[k]*arr[l];
					if(val<dp[i][l])
						dp[i][l]=val;
				}
				++l;
			}
		}
		return dp[size-1][size-1];
		
	}
}
