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
    public int splitArray(int[] nums, int k) {
        this.n =  nums.length;
        this.dp = new int[n][k+1];
        this.nums = nums;
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return memo(0,k);

    }
}