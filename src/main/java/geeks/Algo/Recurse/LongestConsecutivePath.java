package geeks.Algo.Recurse;

public class LongestConsecutivePath {
	static int R=3;
	static int C=3;
	public static void main(String[] args) {
		char mat[][] = { {'a','c','d'},
                { 'e','b','a'},
                { 'c','d','f'}};
		
		System.out.println(alen(mat, 'a'));
	}
	
	public static int alen(char[][] inArr, char x){
		int ans=0,si;
		int[][] mat=new int[R+2][C+2];
		for(int i=1;i<=R;i++){
			for(int j=1;j<=C;j++){
				mat[i][j]=(int)inArr[i-1][j-1];
			}
		}
		si=(int)x;
		for(int i=1;i<=R;i++){
			for(int j=1;j<=C;j++){
				if(mat[i][j]==si)
					ans=Math.max(ans,len(mat, i, j));
			}
			
		}
		return ans;
	}
	
	public static int len(int[][] mat, int x, int y){
		int ans=0;
		for(int i=x-1;i<=x+1;i++){
			for(int j=y-1;j<=y+1;j++){
				if(mat[i][j]==mat[x][y]+1)
					ans=Math.max(ans, len(mat,i,j));
			}
		}
		return 1+ans;
	}

}
