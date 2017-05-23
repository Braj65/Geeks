package geeks.Algo.Recurse;

public class Subset_Sum {
	
	public static void main(String[] args) {
		int[] inArr={3,34,4,5};
		int sum=9;
		System.out.println(isSubsetSum(inArr, inArr.length-1, sum));
	}
	
	public static boolean isSubsetSum(int[] in, int n, int sum){
		
		if(sum==0)
			return true;
		if(sum!=0 && n<0)
			return false;
		
		return isSubsetSum(in, n-1, sum) || isSubsetSum(in, n-1, sum-in[n]);
		
	}

}
