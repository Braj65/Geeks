package geeks.Algo.Recurse;

public class SumOfDigitsEqualsNum {
	public static void main(String[] args) {
		int sum=5;
		int n=2;
		System.out.println(countRec(5, n));
	}
	
	public static int  countRec(int sum, int n){
		if(n==1)
			return 1;
		
		int count=0;
		for(int i=0;i<sum;i++){
			count=count+countRec(sum-i, n-1);			
		}
		
		return count;
	}

}
