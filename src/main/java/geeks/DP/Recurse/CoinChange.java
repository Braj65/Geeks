package geeks.DP.Recurse;

public class CoinChange {
	
	public static void main(String[] args) {
		int n=4;
		int[] s={1,2,3};
		int m=s.length;
		System.out.println(count(s, m, n));
	}
	//it is a variation of knapsack problem
	public static int count(int[] s, int m ,int n){
		if(n==0)
			return 1;
		
		if(n<0)
			return 0;
		
		if(m<=0 && n>=1)
			return 0;
		
		return count(s, m-1, n)+count(s, m, n-s[m-1]);
	}

}
