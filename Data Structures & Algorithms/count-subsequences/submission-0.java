class Solution {
    int dp[][];
    String s;
    String t;
    int memo(int i,int j){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=0;
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] += (memo(i+1,j+1)+memo(i+1,j));
        }
        else{
            dp[i][j] += memo(i+1,j);
        }
        return dp[i][j];
     }
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return memo(0,0);
    }
}
