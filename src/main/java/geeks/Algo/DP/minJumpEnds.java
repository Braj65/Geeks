package geeks.Algo.DP;

public class minJumpEnds {
	public static void main(String[] args) {
//		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		minJumps(inArr, inArr.length-1);
	}
	
	public static int minJumps(int[] arr, int n){
		int[] jumps=new int[n];
		
		if(n==0||arr[0]==0){
			return Integer.MAX_VALUE;
		}
		
		jumps[0]=0;
		
		for(int i=1;i<n;i++){
			jumps[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++){
				if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE){
					jumps[i]=Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		
		return jumps[n-1];
	}

}
