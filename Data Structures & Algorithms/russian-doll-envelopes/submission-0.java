class Solution {
    int dp[];
    int n ;
    int[][] arr;
    int memo(int i){
        if(i==n){return 0;}
        if(dp[i]!=-1) return dp[i];
        int ans = 1;
        for(int j=i+1;j<n;j++){
            if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1]){
                ans = Math.max(ans,1+memo(j));
            }
        }
      
        return dp[i]=ans;

    }
    public int maxEnvelopes(int[][] envelopes) {
        this.arr = envelopes;
        Arrays.sort(envelopes,(x,y)->x[0]-y[0]);
        this.n = envelopes.length;
        this.dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,memo(i));
        }
        return ans;



    }
}