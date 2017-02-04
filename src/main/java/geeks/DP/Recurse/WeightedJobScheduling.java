package geeks.DP.Recurse;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
	public static Integer[][] jobArr={{3, 10, 20}, {1, 2, 50}, {6, 19, 100}, {2, 100, 200}};
	public static void main(String[] args) {
		int n=jobArr.length;
		System.out.println(findMaxProfit(jobArr, n));
	}
	
	public static int findMaxProfit(Integer[][] jobArr, int n){
		Arrays.sort(jobArr, new Valcomparator());
		return findMaxProfitRec(jobArr, n);
	}
	
	public static int findMaxProfitRec(Integer[][] jobArr, int n){
		if(n==1)
			return jobArr[n-1][2];
		
		int inclProf=jobArr[n-1][2];
		int i=latestNonConflict(jobArr, n);
		if(i!=-1)
			inclProf+=findMaxProfitRec(jobArr, i+1);
		
		
		int exclProf=findMaxProfitRec(jobArr, n-1);
		return Math.max(inclProf, exclProf);
	}
	
	public static int latestNonConflict(Integer[][] jobArr, int n){
		for(int j=n-1; j>=0;j--){
			if(jobArr[j][1]<=jobArr[n-1][0])
				return j;
		}
		return -1;
	}
	
	static class Valcomparator implements Comparator<Integer[]>{
		public int compare(Integer[] a, Integer[] b){
			return a[1].compareTo(b[1]);
		}
	}

}
