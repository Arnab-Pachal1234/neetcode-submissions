class Solution {
    int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        int n = grid.length;
        int m = grid[0].length;
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            for(int d[] : dir){
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    int newdist = Math.max(grid[nx][ny],curr[2]);
                    if(dist[nx][ny]>newdist){
                        dist[nx][ny] = newdist;
                        pq.add(new int[]{nx,ny,newdist});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
