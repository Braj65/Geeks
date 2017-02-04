package geeks.DP.DP;

public class MinCostPath {

	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3 }, { 1, 4, 8 }, { 1, 5, 3 } };

		int r = minCost(input, 2, 2);
		System.out.println(r);
	}

	public static int minCost(int[][] x, int a, int b) {
		int[][] dp = new int[a + 1][b + 1];

		dp[0][0] = x[0][0];
		for (int j = 1; j <= a; j++) {
			dp[0][j] = dp[0][j - 1] + x[0][j];
		}

		for (int i = 1; i <= b; i++) {
			dp[i][0] = dp[i - 1][0] + x[i][0];
		}

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				dp[i][j] = x[i][j] + min(dp[i - 1][j], 
						dp[i - 1][j - 1], 
						dp[i][j - 1]);
			}
		}
		return dp[a][b];
	}

	public static int min(int x, int y, int z) {
		if (x < y && x < z)
			return x;
		else if (y < x && y < z)
			return y;
		else
			return z;
	}

}
