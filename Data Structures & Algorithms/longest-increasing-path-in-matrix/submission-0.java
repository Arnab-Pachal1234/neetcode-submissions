
class Solution {
    private int rows, cols;
    private int[][] dp;
    private int[][] dirs = {
        {1, 0},   // down
        {-1, 0},  // up
        {0, 1},   // right
        {0, -1}   // left
    };

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        dp = new int[rows][cols];

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int r, int c) {
        // Already calculated
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int maxPath = 1; // minimum path length is the cell itself

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (
                nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                matrix[nr][nc] > matrix[r][c]
            ) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, nr, nc));
            }
        }

        dp[r][c] = maxPath;
        return maxPath;
    }
}