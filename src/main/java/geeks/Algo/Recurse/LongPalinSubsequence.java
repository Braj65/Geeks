package geeks.Algo.Recurse;

//http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
public class LongPalinSubsequence {
	
	public static void main(String[] args) {
		String x="ABCDBC";
		int len=x.length();
		char[] y=x.toCharArray();
		System.out.println(longPalSub(y, 0, y.length-1));
	}
	
	public static int longPalSub(char[] x, int start, int end){
		if(start==end)
			return 1;
		
		if(x[start]==x[end] && start+1==end)
			return 2;
		
		if(x[start]==x[end]){
			return 2+longPalSub(x, start+1, end-1);
		}else{
			return Math.max(longPalSub(x, start+1, end), longPalSub(x, start, end-1));
		}
	}

}
