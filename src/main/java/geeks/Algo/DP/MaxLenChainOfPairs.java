package geeks.Algo.DP;

public class MaxLenChainOfPairs {
	static int max=1;
	public static void main(String[] args) {
		int[][] inArr={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		
		maxChainLength(inArr, inArr.length);
//		System.out.println(maxLen);
	}
	
	public static int maxChainLength(int[][] in, int len){
		
		int[] lis=new int[len];
		for(int i=0;i<len;i++)
			lis[i]=1;
			
		
		for(int i=1;i<len;i++){
			for(int j=0;j<i;j++){
				if(in[i][0]>in[j][1] && lis[i]<1+lis[j])
					lis[i]=1+lis[j];
			}
		}
		
		for (int i = 0; i < len; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

}
