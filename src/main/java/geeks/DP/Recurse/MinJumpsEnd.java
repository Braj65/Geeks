package geeks.DP.Recurse;

public class MinJumpsEnd {
	public static void main(String[] args) {
//		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		minJumps(inArr, 0, inArr.length-1);
	}
	
	public static int minJumps(int[] arr, int l, int h){
		if(h==l)
			return 0;
		
		if(arr[l]==0)
			return Integer.MAX_VALUE;
		
		int min=Integer.MAX_VALUE;
		
		for(int i=l+1;i<=h && i<=l+arr[l];i++){
			int jumps=minJumps(arr, i, h);
			if(jumps!=Integer.MAX_VALUE && jumps+1<min)
				min=jumps+1;
		}
		
		return min;
	}

}
