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
    String tabulationConstantSpace(){
        int a = 0;
        int b = 0;
        int c = 0;
        for(int i=n-1;i>=0;i--){
        int ans =Integer.MIN_VALUE;
        int sum =0;
        for(int j=0;j<3 && i+j<n ;j++){
            sum+=nums[i+j];
            if(j==0){
                ans = Math.max(ans,sum-a);
            }
            else if(j==1){
                ans = Math.max(ans,sum-b);
            }
            else {
                ans =Math.max(ans,sum-c);
            }
        }
        c=b;
        b=a;
        a=ans;
        }
        if(a==0) return "Tie";
        else if(a>0) return "Alice";
        else return "Bob";
            }
    public String stoneGameIII(int[] stoneValue) {
        this.nums = stoneValue;
        this.n = stoneValue.length;
        this.dp =new int[n];
        return tabulationConstantSpace();
       }
}