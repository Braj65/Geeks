package geeks.Algo.Recurse;

public class Incomp_MaxAsUsing4Keys {
	public static void main(String[] args) {
		for(int i=1;i<=8;i++){
			System.out.println(findOptimal(i));
		}
	}
	
	public static int findOptimal(int n){
		if(n<=6)
			return n;
		
		int max=0;
		int b;
		for(int j=n-3;j>=1;j--){
			int curr=(n-j-1)*findOptimal(j);
			if(curr>max)
				max=curr;
		}
		
		return max;
	}

}
