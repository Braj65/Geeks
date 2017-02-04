package geeks.DP.Recurse;

public class Partitionproblem {
	
	public static void main(String[] args) {
		int[] inArr={3, 1, 5, 9, 12};
		System.out.println(findPartition(inArr, inArr.length));
		
	}
	
	public static boolean findPartition(int[] in, int length){
		int sum=0;
		for(int x:in){
			sum=sum+x;
		}
		
		if(sum%2!=0)
			return false;
		
		return isSubsetSum(in, in.length, sum/2);
	}
	
	public static boolean isSubsetSum(int[] in, int pos, int sum){
		
		if(sum==0)
			return true;
		if(pos==0 && sum!=0)
			return false;
		
		if(in[pos-1]>sum)
			return isSubsetSum(in, pos-1, sum);
		
		return isSubsetSum(in, pos-1, sum-in[pos-1])||isSubsetSum(in, pos-1, sum);			
	}

}
