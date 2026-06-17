class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] =  new boolean[n][m];
        int cnt =0;
        for(int i=0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    cnt++;
                    Queue<int[]> q =new LinkedList<>();
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                    while(!q.isEmpty())
                    {
                        int[] c = q.poll();
                        for(int [] d : dir)
                        {
                            int newr = c[0]+d[0];
                            int newc = c[1]+d[1];
                            if(newr>=0 && newc>=0 && newr<n && newc <m && !vis[newr][newc] && grid[newr][newc]=='1')
                            {
                                vis[newr][newc] = true;
                                q.add(new int[]{newr,newc});
                            }
                            
                        }

                    }
                }
            }
        }
        return cnt;
    }
}
