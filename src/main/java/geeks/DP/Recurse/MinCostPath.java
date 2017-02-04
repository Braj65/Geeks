package geeks.DP.Recurse;

public class MinCostPath {
	
	public static void main(String[] args) {
		int[][] input={{1,2,3},{1,4,8},{1,5,3}};
		
		int r=minCost(input, 2, 2);
		System.out.println(r);
		
	}
	
	public static int minCost(int[][] x, int m, int n){
		
		if(n<0){
			return Integer.MAX_VALUE;
		}else if(m<0){
			return Integer.MAX_VALUE;
		}else if(m==0 && n==0){
			return x[m][n];
		}
		else{
			return x[m][n]+min(minCost(x, m, n-1),
					minCost(x, m-1, n-1),
					minCost(x, m-1, n));
		}
		
	}
	
	public static int min(int x, int y, int z){
		if(x<y && x<z)
			return x;
		else if(y<x && y<z)
			return y;
		else
			return z;
	}
}
