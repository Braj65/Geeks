package geeks.Algo.Recurse;

public class MinJumpsEnd_Self {
	
	public static void main(String[] args) {
//		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] inArr={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(inArr, inArr.length-1));
		System.out.println(min(inArr, inArr.length-1));
	}
	
	public static int minJumps(int[] in, int pos){
		int len=0;
		int min=Integer.MAX_VALUE;
		if(pos==0)
			return 1;
		
		for(int i=pos-1;i>=0;i--){
			if(pos>i+in[i]){
				continue;
			}else{
				len=1+minJumps(in, i);
			}
			if(len<min)
				min=len;
		}
		return min;
	}
	
	public static int min(int[] in, int pos){
		int res=0;
		int min=Integer.MAX_VALUE;
		if(pos==0)
			return 1;
		
		for(int i=0;i<pos;i++){
			res=min(in, i);
			if(pos<=i+in[i] && res+1<min)
				min=res+1;			
		}
		return min;
	}

}
