/**
* 给定一个二维矩阵D,大小为m*n,矩阵D有如下性质：1.每一行从左到右依次增加；2.每一行的第一个数比上一行的最后一个数大 eg：
* D = [
* [2, 4, 6, 8],
* [11, 15, 16, 22],
* [24, 31, 33, 40]
* ]
* 判断给定的一个数字tar是否在矩阵中；if (tar == 15) return true;
*/

public class FindInMatrix{

	// O(log(m*n))
	public static boolean contains(int[][] matrix, int tar){
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;
		int m = matrix.length, n = matrix[0].length;
		int lo = 0, hi = m*n - 1;  // starting from 0 to m*n - 1 can simplify the i,j reflection.
		int mid = 0, i = 0, j = 0;
		while(lo <= hi){
			mid = lo + (hi - lo) / 2;
			i = mid / n;
			j = mid % n;
			if(matrix[i][j] > tar) hi = mid - 1;
			else if(matrix[i][j] < tar) lo = mid + 1;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix  = {{2,4,6,8},{11,15,16,22},{24,31,33,40}};
		for(int i = 0; i < matrix.length; i ++)
			for(int j = 0; j < matrix[0].length; j++)
				System.out.println("Contains" + matrix[i][j] + ": " + contains(matrix, matrix[i][j]));
		System.out.println("Contains" + 44 + ": " + contains(matrix, 44));
		System.out.println("Contains" + 1 + ": " + contains(matrix, 1));
		System.out.println("Contains" + 17 + ": " + contains(matrix, 17));
	}
}
