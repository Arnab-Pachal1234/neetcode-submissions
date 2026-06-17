class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i =0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0) q.add(new int[]{i,j,0});

            }
        }
            int n = grid.length;
            int m = grid[0].length;
            boolean vis[][]  = new boolean[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j =0;j<m;j++)
                {
                    if(grid[i][j]==0 || grid[i][j]==-1) vis[i][j]=true;
                }
            }
            while(!q.isEmpty())
            {
                int [] curr = q.poll();
                for(int [] d : dir)
                {
                    int newr =  curr[0]+d[0];
                    int newc = curr[1] + d[1];
                    if(newr>=0 && newc>=0 && newr<n && newc<m && !vis[newr][newc])
                    {
                        grid[newr][newc] = curr[2]+1;
                        vis[newr][newc] = true;
                        q.add(new int[]{newr , newc , grid[newr][newc]});
                    }
                }
            }
        }
    }

