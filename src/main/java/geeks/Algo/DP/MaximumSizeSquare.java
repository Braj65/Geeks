package geeks.Algo.DP;

public class MaximumSizeSquare {
	
	public static void main(String[] args) {
		int[][] inArr={{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		System.out.println(sizeSquare(inArr, inArr.length));
	}
	
	public static int sizeSquare(int[][] in, int pos){
		int[][] temp=new int[in.length][in[0].length];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<in.length;i++){
			temp[i][0]=in[i][0];
		}
		
		for(int j=0;j<in[0].length;j++){
			temp[0][j]=in[0][j];
		}
		
		for(int i=1;i<temp.length;i++){
			for(int j=1;j<temp[i].length;j++){
				if(in[i][j]==1)
					temp[i][j]=min(temp[i-1][j], temp[i][j-1], temp[i-1][j-1])+1;
				else
					temp[i][j]=0;
				if(max<temp[i][j])
					max=temp[i][j];
			}
		}
		return max;
	}
	
	public static int min(int a, int b, int c){
		if(a<b && a<c)
			return a;
		else if(b<c && b<a)
			return b;
		else
			return c;
	}
}


