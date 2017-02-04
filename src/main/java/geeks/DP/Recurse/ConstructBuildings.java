package geeks.DP.Recurse;

public class ConstructBuildings {
	
	public static void main(String[] args) {
		int x=countWays(5);
		
		System.out.println(x*x);
	}
	
	public static int countWays(int n){
		if(n==0)
			return 1;
		if(n==1)
			return 2;
		
		int x=countSpace(n);
		int y=countBuild(n);
		
		return x+y;
	}
	
	public static int countSpace(int n){
		if(n==0 || n==1)
			return 1;
		return countSpace(n-1)+countSpace(n-2);
	}
	
	public static int countBuild(int n){
		if(n==0 || n==1)
			return 1;
		return countSpace(n-1);
	}
	

}
