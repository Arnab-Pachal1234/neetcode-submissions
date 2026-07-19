class Solution {
    int cnt;
    ArrayList<Integer>[] graph;
    int  n;
    List<Boolean> hasApple; 
    boolean visit(int node,int parent){
        
        boolean res = hasApple.get(node);
      
        for(Integer ch : graph[node]){
            if (ch==parent) continue;
        boolean check = visit(ch,node);
        if(check) cnt+=2;
        res |=check;
        }
        return res;
    }
    @SuppressWarnings("unchecked")
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph= new ArrayList[n];
        this.hasApple = hasApple;
        this.n = n;
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[] : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        this.cnt = 0;
        visit(0,-1);
        return cnt;
    }
}