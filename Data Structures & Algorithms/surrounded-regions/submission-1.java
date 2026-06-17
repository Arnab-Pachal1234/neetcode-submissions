class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        Queue<int[]> q =new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            if(board[i][0]=='O'){ q.add(new int[]{i,0}); vis[i][0]=true;}
            if(board[i][m-1]=='O'){ q.add(new int[]{i,m-1});vis[i][m-1]=true;}
        }
         for(int i=0;i<m;i++)
        {
            if(board[0][i]=='O'){ q.add(new int[]{0,i}); vis[0][i]=true;}
            if(board[n-1][i]=='O'){ q.add(new int[]{n-1,i});vis[n-1][i]=true;}
        }
        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            for(int d[] : dir)
            {
                int nr = curr[0]+d[0];
                int nc = curr[1]+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc] &&  board[nr][nc]=='O')
                {   vis[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='O' && !vis[i][j]){board[i][j]='X';}
            }
        }
        
    }
}
