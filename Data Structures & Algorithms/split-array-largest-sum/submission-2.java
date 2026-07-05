class Solution {
    int dp[][];
    int nums[];
    int n;
    int memo(int i,int k){
        if(i==n && k==0){
            return 0;
        }
        else if(i==n || k == 0) return Integer.MAX_VALUE;
        if(dp[i][k]!=-1) return dp[i][k];
        int sum=nums[i];
        int ans = Integer.MAX_VALUE;
        for(int j=i+1;j<=n;j++){
            int currres = Math.max(sum,memo(j,k-1));
            ans = Math.min(ans,currres);
            if(j!=n)sum += nums[j];
        }
        return dp[i][k]=ans;
    }
    int tabulation(int n,int m){
        for(int i=0;i<=n;i++){
            dp[i][0]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=m;i++){
            dp[n][i]=Integer.MAX_VALUE;
        }
        dp[n][0]=0;
        for(int i=n-1;i>=0;i--){
           
           for(int l=1;l<=m;l++){
           int ans = Integer.MAX_VALUE;
            int sum =nums[i];
           for(int j=i+1;j<=n;j++){
            
             ans = Math.min(ans,Math.max(sum,dp[j][l-1]));
             if(j!=n) sum += nums[j];
           }
           dp[i][l]=ans;
        
        }
        
    }
    return dp[0][m];
    }
    public int splitArray(int[] nums, int k) {
        this.n =  nums.length;
        this.dp = new int[n+1][k+1];
        this.nums = nums;
        return tabulation(n,k);
     

    }

}
