package geeks.Algo.Recurse;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String str1= "abacdc";
		char[] str=str1.toCharArray();
		System.out.println(minPalPartion(str, 0, str.length-1));
	}
	
	public static int minPalPartion(char[] str, int start, int end){
		int min=Integer.MAX_VALUE;
		int count=0;
		if(str[start]==str[end]){
			if(checkPal(str, start, end)){
				return 0;
			}
		}
		if(start==end)
			return 0;
		
		else{
			for(int k=start;k<end;k++){
				count= 1+minPalPartion(str, start, k)+minPalPartion(str, k+1, end);
				if(count<min)
					min=count;
			}			
		}
		return min;
		
	}
	
	public static boolean checkPal(char[] str, int start , int end){
		if(start==end){
			return true;
		}
		if(str[start]==str[end] && start+1==end)
			return true;
		if(str[start]==str[end]){
			return checkPal(str, start+1, end-1);
		}else{
			return false;
		}
	}

}
