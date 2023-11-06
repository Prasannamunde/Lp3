public class NQueen {
	static int[][] board;
	public static boolean isSafe(int row, int col, int N)
	{
		int i, j;
		// Check the left side of the current row
		for (i = 0; i < col; i++)
		{
			if (board[row][i] == 1)
			{
			return false;
			}
		}
		// Check upper diagonal on left side
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j] == 1) 
			{
			return false;
			}
		}
		// Check lower diagonal on left side
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
		{
			if (board[i][j] == 1)
			{
			return false;
			}
		}
		
		return true;
	}
	public static boolean solveNQueensUtil(int N, int col)
	{
		if (col >= N)
		{
			return true;
		}
		for (int i = 0; i < N; i++)
		{
			if (isSafe(i, col, N)) 
			{
				board[i][col] = 1;
				if (solveNQueensUtil(N, col + 1)) 
				{
					return true;
				}
				board[i][col] = 0; // Backtrack
			}
		}
		return false;
	}
	public static void solveNQueens(int N)
	{
		board = new int[N][N];
		// Place the first queen
		board[0][0] = 1;
		if (!solveNQueensUtil(N, 1)) {
		System.out.println("Solution does not exist");
		return;
		}
		// Print the final board
		System.out.println("Final N-Queens Board:");
		printBoard(N);
	}
	public static void printBoard(int N) 
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int N = 4; // Change N for different board sizes
		solveNQueens(N);
	}
}


