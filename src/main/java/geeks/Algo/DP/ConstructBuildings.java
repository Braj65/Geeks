package geeks.Algo.DP;

public class ConstructBuildings {
	
	public static void main(String[] args) {
		System.out.println(countWays(4));
	}
	
	public static int countWays(int n){
		if(n==1)
			return 4;
		
		int countB=1, countS=1, prev_countB, prev_countS;
		
		for(int i=2;i<=n;i++){
			prev_countB=countB;
			prev_countS=countS;
			
			countS=prev_countS+prev_countB;
			countB=prev_countS;
		}
		
		int result=countS+countB;
		
		return result*result;
	}

}
