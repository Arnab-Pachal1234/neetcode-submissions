
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        // Initialize the empty board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Tracking arrays for O(1) lookups
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        
        backtrack(0, n, board, results, cols, posDiag, negDiag);
        return results;
    }
    
    private void backtrack(int row, int n, char[][] board, List<List<String>> results,
                           boolean[] cols, boolean[] posDiag, boolean[] negDiag) {
        // Base case: all queens placed successfully
        if (row == n) {
            results.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col + (n - 1);
            
            // Check if square is under attack
            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue;
            }
            
            // Place the queen
            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;
            
            // Move to the next row
            backtrack(row + 1, n, board, results, cols, posDiag, negDiag);
            
            // Backtrack: Remove the queen and try the next column
            board[row][col] = '.';
            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }
    
    // Helper method to convert the char[][] to the required List<String> format
    private List<String> constructBoard(char[][] board) {
        List<String> currentSolution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            currentSolution.add(new String(board[i]));
        }
        return currentSolution;
    }
}