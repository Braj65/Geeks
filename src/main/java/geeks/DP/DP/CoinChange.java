package geeks.DP.DP;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int n=4;
		int[] s={1,2,3};
		int m=s.length;
		System.out.println(count(s, m, n));
	}
	//it is a variation of knapsack problem
	public static long count(int[] s, int m, int n){
		long[] table=new long[n+1];
		Arrays.fill(table, 0);
		
		table[0]=1;
		//so how the below method is working is- In the columns of the table we have kept the target sum using the only coin
		//at s[i] location. So if target sum is 3 and the coin at s[i] location is 2, we are finding the no. of ways we can
		//get 3 using coin 2 and below. One catch is when using the coin s[i] we are looking for any target value, the target
		//value will only be >=s[i] and not below it. So in inner loop we have started from j=s[i]. j[i] captures the
		//target value which increments.
		//Plot a 2-d array where row vals= value of coins supplied and column values will be target sum strating from 0
		//to the target sum value.
		//Now when we have a target value 3 and to calculate no. of ways it can be achieved we are adding two parts.
		//1st part is the existing value in that location. This is to capture the no. of ways the target value can be
		//represented using the previous coin. The previous coin will be the previous row.
		//2nd part is little tricky. For ex- 6 is target and 2 is the coin.Here we are assuming that we are using atleast one
		//2 coin. So if we are using one 2 coin, then we are only left with the question how many ways we can arrange the
		//sum 4. because 4+2 is 6. So total no. of ways to get 4 using using the coin in question which is 2+ the atleast
		//2 coin we have in hand. So we are finding the total no. of ways we can get target val(6)-coin(2) i.e t[6-s[i]];
		
		for(int i=0;i<m;i++){
			for(int j=s[i];j<=n;j++){
				table[j]+=table[j-s[i]];
			}
		}
		
		return table[n];
	}

}
