class Solution {
     int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
          Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2) q.add(new int[]{i,j,0});

            }
        }
            int n = grid.length;
            int m = grid[0].length;
            boolean vis[][]  = new boolean[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j =0;j<m;j++)
                {
                    if(grid[i][j]==0 || grid[i][j]==2) vis[i][j]=true;
                }
            }
            int maxtime = 0;
            while(!q.isEmpty())
            {
                int [] curr = q.poll();
                maxtime =Math.max(maxtime,curr[2]);
                for(int [] d : dir)
                {
                    int newr =  curr[0]+d[0];
                    int newc = curr[1] + d[1];
                    if(newr>=0 && newc>=0 && newr<n && newc<m && !vis[newr][newc])
                    {
                        grid[newr][newc] = 2;
                        vis[newr][newc] = true;
                        q.add(new int[]{newr , newc ,curr[2]+1});
                    }
                }
            }
            boolean check = true;
            for(int[] g : grid)
            {
                for(int el : g)
                {
                    if(el==1) check = false;
                }
            }
            if(!check) return -1;
            return maxtime; 
    }
}
