class Solution {
    int cnt;
    int n;
    boolean[] cols ;
    boolean[] posDiag ; // row + col
    boolean[] negDiag ;
    
    void solve(int row) {

    if(row == n){
        cnt++;
        return;
    }

    for(int col = 0; col < n; col++){

        int pd = row + col;
        int nd = row - col + n - 1;

        if(cols[col] || posDiag[pd] || negDiag[nd])
            continue;

        cols[col] = true;
        posDiag[pd] = true;
        negDiag[nd] = true;

        solve(row + 1);

        cols[col] = false;
        posDiag[pd] = false;
        negDiag[nd] = false;
    }
}
    public int totalNQueens(int n) {
        cnt =0;
        this.n = n;
        cols = new boolean[n];
        posDiag = new boolean[2*n];
        negDiag = new boolean[2*n];
        solve(0);
        
        return cnt;
    }
}