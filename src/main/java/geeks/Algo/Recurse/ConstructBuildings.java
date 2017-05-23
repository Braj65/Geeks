package geeks.Algo.Recurse;

public class ConstructBuildings {
	
	public static void main(String[] args) {
		int x=countWays(5);
		int y=countAll(5);
		System.out.println(y*y);
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
	
	public static int countAll(int n){
		if(n==0)
			return 1;
		if(n==1)
			return 2;
		return countAll(n-1)+countAll(n-2);
	}
	

}
