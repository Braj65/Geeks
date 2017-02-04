package geeks.DP.Recurse;

public class Knapsack {
	public static void main(String[] args) {
		int[] val={60, 100, 120};
		int[] wt={10,20,30};
		int tarWt=50;
		System.out.println(knap(val, wt, 0, tarWt));
	}
	
	public static int knap(int[] val, int[] wt, int i, int tarWt){
		if(i>wt.length-1)
			return 0;
		if(tarWt<wt[i])
			return knap(val, wt, i+1, tarWt);
		else
			return Math.max(val[i]+knap(val, wt, i+1, tarWt-wt[i]), knap(val, wt, i+1, tarWt));		
	}

}
