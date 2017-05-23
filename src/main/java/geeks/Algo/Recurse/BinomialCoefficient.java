package geeks.Algo.Recurse;

public class BinomialCoefficient {
	public static void main(String[] args) {
		int n=4;
		int k=2;
		System.out.println(coeff(4,2));
	}
	
	public static int coeff(int n, int k){
		if(k==0)
			return 1;
		if(n==k)
			return 1;
		else
			return coeff(n-1, k-1)+coeff(n-1, k);
		
	}

}
