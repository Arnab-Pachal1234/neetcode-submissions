class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //use Djkstra's
        // maximum of minimum distance 
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i]=new ArrayList<>();
        for(int t[] : times)
        {
            int u = t[0];
            int v = t[1];
            int time = t[2];
            graph[u].add(new int[]{v,time});
        }
        int dist[]  = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            for(int neighedge[] : graph[curr[0]])
            {
                int neigh = neighedge[0];
                int wt = neighedge[1];
                if(curr[1]+wt<dist[neigh]) 
                {
                    dist[neigh]=curr[1]+wt;
                    pq.add(new int[]{neigh,dist[neigh]});
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            ans = Math.max(ans,dist[i]);
        }
        if(ans == Integer.MAX_VALUE)  return -1;
        return ans;

    }
}
