package geeks.DP.Recurse;

public class NonDecreasingNumbers {
	public static void main(String[] args) {
		int n=2;
		System.out.println(countNonDecreasing(2, 9));
	}
	
	public static int countNonDecreasing(int n, int d){
		int res=0;
		if(n==0)
			return 1;
		/*if(n==1)
			return 1;*/
		
		for(int i=0;i<=d;i++){
			res=res+countNonDecreasing(n-1, i);
		}
		
		return res;
	}

}
