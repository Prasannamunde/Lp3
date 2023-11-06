public class NQueens {

    public static void main(String[] args) {
        int n = 4; // Change 'n' to the desired board size
        int[][] board = new int[n][n];

        // Place the first queen at a specific position (row, col)
        int row = 1;
        int col =2;
        board[row][col] = 1;

        if (solveNQueens(board, 1)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Function to solve the N-Queens problem using backtracking
    public static boolean solveNQueens(int[][] board, int col) {
        int n = board.length;
        if (col == n) {
            return true; // All queens are placed successfully
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place a queen
                if (solveNQueens(board, col + 1)) {
                    return true; // Recursive call to place the next queen
                }
                board[i][col] = 0; // If placing queen here doesn't lead to a solution, backtrack
            }
        }

        return false; // If no safe spot is found for this column
    }

    // Function to check if a queen can be placed at a given position
    public static boolean isSafe(int[][] board, int row, int col) {
        int n = board.length;

        // Check the left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to print the N-Queens board
    public static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}