package geeks.Algo.Recurse;

public class WaysReachNthStair {
	public static void main(String[] args) {
		int stairs=4;
		System.out.println(countWays(3));
	}
	
	public static int countWays(int n){
		if(n==0 || n==1)
			return 1;
		
		return countWays(n-1)+countWays(n-2);
		
	}

}
