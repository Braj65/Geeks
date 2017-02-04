package geeks.DP.Recurse;

public class MinSquares {
	public static void main(String[] args) {
		System.out.println(getMinSquares(10));
	}
	
	public static int getMinSquares(int n){
		if(n<=3)
			return n;
		
		int res=n;
		
		for(int x=1;x<=n;x++){
			int temp=x*x;
			if(temp>n)
				break;
			else
				res=Math.min(res, 1+getMinSquares(n-temp));
		}
		return res;
	}

}
