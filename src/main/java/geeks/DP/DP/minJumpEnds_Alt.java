
package geeks.DP.DP;
public class minJumpEnds_Alt {
	
	public static void main(String[] args) {
//		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		minJumps(inArr, inArr.length-1);
	}
	
	public static int minJumps(int[] arr, int n){
		int[] jumps=new int[n];
		int min;
		
		jumps[n-1]=0;
		
		for(int i=n-2;i>=0;i--){
			if(arr[i]==0)
				jumps[i]=Integer.MAX_VALUE;
			else if(arr[i]>=n-i-1)
				jumps[i]=1;
			else{
				min=Integer.MAX_VALUE;
				for(int j=i+1;j<n && j<=arr[i]+i;j++){
					if(min>jumps[j])
						min=jumps[j];
				}
				
				if(min!=Integer.MAX_VALUE)
					jumps[i]=min+1;
				else
					jumps[i]=min;
			}
		}
		return jumps[0];
	}

}
