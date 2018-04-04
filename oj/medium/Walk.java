/**
* 给定一个M*N的棋盘（M <= 100, N <=100）
* 一个人站在左上角，他只能向右或者向下行走，现在他要走到右下角的终点，有多少种走法？
* 时间复杂度最好为O(m*n)
*/


public class Walk{

	// 使用递归应该达不到O(m*n)
	public static int totalPaths(int M, int N){
		if(M < 0 || N < 0) throw new IllegalArgumentException();
		if(M == 0 || N == 0) return 0;
		int[][] matrix = new int[M][N];
		matrix[M - 1][N - 1] = 0;
		for(int j = 0; j < N - 1; j ++)
			matrix[M - 1][j] = 1;
		for(int i = 0; i < M - 1; i ++)
			matrix[i][N - 1] = 1;
		// int k = N > M ? M - 2: N - 2;
		// int row = M - 2, col = N - 2;
		// for(; k >= 0; k --){
		// 	for(int i = col; i >=0; i --)
		// 		matrix[row][i] = matrix[row + 1][i] + matrix[row][i + 1];
		// 	for(int j = row - 1; j >= 0; j --)
		// 		matrix[j][col] = matrix[j+1][col] + matrix[j][col + 1];
		// 	row --;
		// 	col --;
		// }

		for(int i = M - 2; i >= 0; i--)
			for(int j = N - 2; j >= 0; j--)
				matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
		// show the matrix
		// for(int i = 0; i < M; i++){
		// 	for(int j = 0; j < N; j++)
		// 		System.out.print(matrix[i][j] + " ");
		// 	System.out.println();
		// }
			
		return matrix[0][0];
	}

	public static void main(String[] args) {
		System.out.println("Total paths in (0,0) chessboard:" + totalPaths(0,0));
		System.out.println("Total paths in (1,1) chessboard:" + totalPaths(1,1));
		System.out.println("Total paths in (2,2) chessboard:" + totalPaths(2,2));
		System.out.println("Total paths in (3,3) chessboard:" + totalPaths(3,3));
		System.out.println("Total paths in (4,4) chessboard:" + totalPaths(4,4));
		System.out.println("Total paths in (6,6) chessboard:" + totalPaths(6,6));
	}
}