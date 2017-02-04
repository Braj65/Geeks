package geeks.DP.Recurse;

public class MaxLenChainOfPairs {
	
	static int maxLen=1;
	public static void main(String[] args) {
		int[][] inArr={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
		
		maxChainLength(inArr, inArr.length);
		System.out.println(maxLen);
	}
	
	public static int maxChainLength(int[][] in, int len){
		if(len==1)
			return 1;
		
		int curChainLen=1;
		for(int i=1;i<len;i++){
			int subChainLen=maxChainLength(in, i);
			
			if(in[i-1][1]<in[len-1][0] && curChainLen<(1+subChainLen)){
				curChainLen=1+subChainLen;
			}
		}
		
		if(maxLen<curChainLen)
			maxLen=curChainLen;
		
		return curChainLen;	
		
	}

}
