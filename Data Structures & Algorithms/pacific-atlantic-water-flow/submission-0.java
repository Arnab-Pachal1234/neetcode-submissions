class Solution {
    int rows, cols;
    int[][] heights;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) dfs(i, 0, pacific);
        for (int j = 0; j < cols; j++) dfs(0, j, pacific);

        for (int i = 0; i < rows; i++) dfs(i, cols - 1, atlantic);
        for (int j = 0; j < cols; j++) dfs(rows - 1, j, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols
                || visited[nr][nc]
                || heights[nr][nc] < heights[r][c]) {
                continue;
            }
            dfs(nr, nc, visited);
        }
    }
}
