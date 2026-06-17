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
        boolean union(int a,int b)
        {
            int parA = find(a);
            int parB = find(b);
            if(parA == parB) return  false ;
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

            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

            int maxel  = 0;
            for(int e[] : edges) maxel  = Math.max(maxel,Math.max(e[0],e[1]));
           DSU du = new DSU(maxel+1);
        for(int e[] : edges) 
        {
           if(!du.union(e[0],e[1]))
           {
            return new int[]{e[0],e[1]};
           }
        }
        return new int[0];
       
    }
}
