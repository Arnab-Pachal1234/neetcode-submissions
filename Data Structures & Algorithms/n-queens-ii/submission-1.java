class Solution {
    int cnt;
    public boolean isValid(int[][] board, int n) {
    // Arrays to track if a queen is present in a specific path
    boolean[] cols = new boolean[n];
    boolean[] posDiag = new boolean[2 * n]; // row + col
    boolean[] negDiag = new boolean[2 * n]; // row - col + (n - 1)

    for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
            // Check if a queen is placed at this cell (1 represents a queen)
            if (board[r][c] == 1) {
                int negDiagIdx = r - c + (n - 1);

                // If the column or diagonals are already occupied, it is invalid
                if (cols[c] || posDiag[r + c] || negDiag[negDiagIdx]) {
                    return false;
                }

                // Mark paths as occupied
                cols[c] = true;
                posDiag[r + c] = true;
                negDiag[negDiagIdx] = true;
            }
        }
    }
    return true; // No conflicts found
}

    void memo(int mat[][],int n,int r){
        if(r==n){
          cnt++;
          return;
        }
        
        for(int i=0;i<n;i++){
            mat[r][i]=1;
            if(isValid(mat,n)){
            memo(mat,n,r+1);
            }
            mat[r][i]=0;
        }

    }
    public int totalNQueens(int n) {
        cnt =0;
        int mat[][]=new int[n][n];
        memo(mat,n,0);
        return cnt;
    }
}