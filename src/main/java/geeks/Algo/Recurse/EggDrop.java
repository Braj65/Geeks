package geeks.Algo.Recurse;


//https://stackoverflow.com/questions/40118972/understanding-egg-drop-algorithm-for-more-than-two-eggs
//http://datagenetics.com/blog/july22012/index.html
public class EggDrop {
	public static void main(String[] args) {
		int n=5;
		int k=2;
		System.out.println(minDrops(100, k));
	}
	
	public static int minDrops(int n, int k){
		
		if(n==1 || n==0)
			return n;
		if(k==1)
			return n;
		
		int min=Integer.MAX_VALUE;
		int res=0;
		for(int i=1;i<=n;i++){
			res=Math.max(minDrops(n-1, k-1), minDrops(n-i, k));
			
			if(res<min){
				min=res;
			}
		}
		return min+1;
	}

}
