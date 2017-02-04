package geeks.DP.Recurse;

public class MinCostTrain {
	
	public static void main(String[] args) {
		int cost[][] = { {0, 15, 80, 90},
                {-1, 0, 40, 50},
                {-1, -1, 0, 70},
                {-1, -1, -1, 0}
              };
		System.out.println(minCostRec(cost, 0, 0));
	}
	
	public static int minCostRec(int[][] cost, int start){
		
		int colLen=cost[0].length-1;
		
		if(start>=colLen)
			return 0;
		if(start+1==colLen)
			return cost[start][colLen];
		
		int min=Integer.MAX_VALUE;
		int res=0;
		
		for(int i=start;i<colLen;i++){
			res=cost[start][i+1]+minCostRec(cost, i+1);
			if(res<min)
				min=res;
		}
		
		return min;
	}
	
	public static int minCostRec(int[][] cost, int s, int d){
		if(s==d || s+1==d){
			return cost[s][d];
		}
		
		int min=cost[s][d];
		
		for(int i=s+1;i<d;i++){
			int c=minCostRec(cost, s, i)+
					minCostRec(cost, i, d);
			if(c<min)
				min=c;
		}
		return min;
	}

}
