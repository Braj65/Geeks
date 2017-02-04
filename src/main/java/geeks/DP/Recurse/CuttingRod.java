package geeks.DP.Recurse;

public class CuttingRod {
	public static void main(String[] args) {
		int val[]={1, 5, 8, 9, 10, 17, 17, 20};
		int wt[]={0,1,2,3,4,5,6,7,8};
		
//		cutRod(wt, val, 8, 8);
		
		System.out.println(cutRod(val, 2));
	}
	
	public static int cutRod(int[] val, int pos){
		int min=Integer.MIN_VALUE;
		if(pos==0)
			return 0;
		else{
			for(int i=1;i<=pos;i++){
				min=Math.max(min, val[i-1]+cutRod(val, pos-i));
			}
		}
		return min;
	}
}
