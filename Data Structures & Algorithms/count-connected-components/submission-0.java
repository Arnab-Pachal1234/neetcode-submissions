class Solution {
    class DSU
    {
        int n;
        int [] par;
        int [] rank;
        DSU(int n)
        {
            this.par = new int[n];
            for(int i=0;i<n;i++) par[i]=i;
            this.rank = new int[n];
        }
        int find(int a)
        {
            if(par[a]==a) return par[a];
            else return par[a] = find(par[a]);
        }
        void union(int a,int b)
        {
            int parA = find(a);
            int parB = find(b);
            if(parA == parB) return ;
            int ranka = rank[parA];
            int rankb = rank[parB];
            if(rank[a]<rank[b])
            {
                par[parA]=parB;
            }
            else
            {
                par[parB]=parA;
            }

            return ;
        }
    }
    public int countComponents(int n, int[][] edges) {
         DSU du = new DSU(n);
        for(int e[] : edges) 
        {
           du.union(e[0],e[1]);
        }
        HashSet<Integer> par = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            par.add(du.find(i));
        }
        return par.size();
    }
}
