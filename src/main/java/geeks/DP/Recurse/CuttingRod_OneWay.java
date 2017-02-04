package geeks.DP.Recurse;

//http://www.cs.uml.edu/~kdaniels/courses/ALG_503_F12/DynamicRodCutting.pdf
public class CuttingRod_OneWay {
	
	public static void main(String[] args) {
		int val[]={1, 5, 8, 9, 10, 17, 17, 20};
		int wt[]={0,1,2,3,4,5,6,7,8};
		
//		cutRod(wt, val, 8, 8);
		
		System.out.println(cutRod(val, 4, 1));
	}
	
	public static int cutRod(int[] wt, int[] val, int tarWt, int pos){
		if(pos==0)
			return 0;
		
		if(tarWt<wt[pos])
			return cutRod(wt, val, tarWt, pos-1);
		else
			return Math.max(val[pos]+cutRod(wt, val, tarWt-wt[pos], pos-1), 
					cutRod(wt, val, tarWt, pos-1));
	}
	
	public static int cutRod(int[] val, int tarWt, int cutPoint){
		int min=Integer.MIN_VALUE;
		int res=0;
		if(cutPoint==tarWt && cutPoint==1)
			return val[0];
		else if(cutPoint==tarWt && cutPoint==0)
			return 0;
		/*else if(cutPoint==tarWt)
			return val[cutPoint];*/
		if(cutPoint==0)
			return val[tarWt-1];
		
		else{
			for(int i=0;i<tarWt;i++){
				 res=cutRod(val, tarWt-i, i)+cutRod(val, i, i);
				 if(res>min)
					min=res;
			}			
		}
		return min;
			
	}

}
