package geeks.Algo.Recurse;

public class TilingProblem {
	public static void main(String[] args) {
		System.out.println(tile(4));
	}
	
	public static int tile(int n){
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else{
			return tile(n-1)+tile(n-2);
		}
	}

}
