class Solution {
    HashMap<String,Integer> dp;
    int[][]  grid;
    int n;
    int m;
    //r1 + c1 == r2+c2
    int memo(int r1,int c1,int r2){
        int c2 = r1+c1-r2;
        String key = r1+"$"+c1+"$"+r2;
        if(dp.containsKey(key)) return dp.get(key);
        if(r1==n || r2 == n || c1==m || c2==m || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==n-1 && c1 == m-1){
            return grid[r1][c1];
        } 
        int ans = grid[r1][c1];
        if(r1!=r2){ans+=grid[r2][c2];}

        int check =  Math.max(memo(r1+1,c1,r2+1),Math.max(memo(r1,c1+1,r2),Math.max(memo(r1+1,c1,r2),memo(r1,c1+1,r2+1))));
        if(check == Integer.MIN_VALUE) {
            dp.put(key,check);
        }
        else{
        dp.put(key,ans+check);        
        }
        
        return dp.get(key);




    }
    public int cherryPickup(int[][] grid) {
        this.dp = new HashMap<>();
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        int ans =  memo(0,0,0);
        if(ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}