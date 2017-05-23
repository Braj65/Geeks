package geeks.Algo.Recurse;

public class MatrixChain {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3 };
		int n = arr.length;
		System.out.println(matrixChain(arr, 1, n - 1));
	}

	/**
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int matrixChain(int[] arr, int start, int end) {

		if (start == end)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = start; k < end; k++) {
			int count = matrixChain(arr, start, k) + matrixChain(arr, k + 1, end) + 
					arr[start - 1] * arr[k] * arr[end];

			if (count < min)
				min = count;
		}
		return min;
	}

}
