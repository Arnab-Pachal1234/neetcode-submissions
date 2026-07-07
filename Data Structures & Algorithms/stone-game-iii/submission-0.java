class Solution {
    int[] nums;
    int n;
    int[] dp;
    int memo(int i){
        if(i==n) return 0; //tie
        if(dp[i]!=-1) return dp[i];
        /*
        if(dp[i]==0) tie 
        dp[i]>0 alice 
        dp[i]<0 bob
        */
        int ans =Integer.MIN_VALUE;
        int sum =0;
        for(int j=0;j<Math.min(3,n-i);j++){
            sum+=nums[i+j];
            ans = Math.max(ans,sum-memo(i+j+1));
        }
        dp[i]=ans;
        return ans;
        }
    public String stoneGameIII(int[] stoneValue) {
        this.nums = stoneValue;
        this.n = stoneValue.length;
        this.dp =new int[n];
        Arrays.fill(dp,-1);
        int ans = memo(0);
        if(ans>0) return "Alice";
        else if(ans<0) return "Bob";
        else return "Tie";
       }
}