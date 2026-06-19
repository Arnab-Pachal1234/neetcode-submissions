class Solution {
    int dp[][];
    int[] nums;
    int memo(int i,int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k =i;k<=j;k++){
            //burst kth ballon 
            int currans = nums[i-1]*nums[k]*nums[j+1] + memo(i,k-1)+ memo(k+1,j);
            ans = Math.max(ans,currans);
        }
      return dp[i][j]=ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int copynums[] = new int[n+2];
        for(int i=1;i<=n;i++){
            copynums[i]=nums[i-1];
        }
        copynums[0]=copynums[n+1]=1;
        this.nums = copynums;
        this.dp = new int[n+2][n+2];
        for(int i=0;i<=n+1;i++)Arrays.fill(dp[i],-1);
        return memo(1,n);
    }
}
