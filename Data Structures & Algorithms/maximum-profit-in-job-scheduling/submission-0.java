class Solution {
    int dp[];
    
    class Triad implements Comparable<Triad>{
        int s;
        int e;
        int p;
        Triad(int p,int s,int e){
            this.s = s;
            this.e = e;
            this.p = p;
        }
        @Override 
        public int compareTo(Triad t){
            return this.s - t.s;
        }
    }
    Triad arr[];
    int n;
    int memo(int i){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans = arr[i].p;
        for(int j=i+1;j<n;j++){
            if(arr[j].s>=arr[i].e){
                ans = Math.max(ans,arr[i].p+memo(j));
            }
        }
        dp[i]=ans;
        return dp[i];
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.n = startTime.length;
        this.arr = new Triad[n];
        for(int i=0;i<n;i++){
            arr[i]=new Triad(profit[i],startTime[i],endTime[i]);
        }
        Arrays.sort(arr);
        this.dp = new int[n];
        Arrays.fill(this.dp ,-1);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,memo(i));
        }
        return ans;

    }
}