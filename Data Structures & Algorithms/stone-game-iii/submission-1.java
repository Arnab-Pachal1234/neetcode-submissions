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
    String tabulation(){
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
        int ans =Integer.MIN_VALUE;
        int sum =0;
        for(int j=0;j<Math.min(3,n-i);j++){
            sum+=nums[i+j];
            ans = Math.max(ans,sum-memo(i+j+1));
        }
        dp[i]=ans;
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        else return "Tie";

    }
    public String stoneGameIII(int[] stoneValue) {
        this.nums = stoneValue;
        this.n = stoneValue.length;
        this.dp =new int[n];
        return tabulation();
       }
}