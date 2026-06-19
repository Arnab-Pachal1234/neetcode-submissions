class Solution {
    String s, p;
    Boolean[][] dp;

    private boolean memo(int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean firstMatch = false;

        if (i < s.length()) {
            firstMatch = p.charAt(j) == s.charAt(i) || p.charAt(j) == '.';
        }

        boolean ans;

        // Check if next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            ans =
                // take 0 occurrence of current pattern char
                memo(i, j + 2)

                ||

                // take 1 or more occurrence
                (firstMatch && memo(i + 1, j));
        } else {
            ans = firstMatch && memo(i + 1, j + 1);
        }

        return dp[i][j] = ans;
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return memo(0, 0);
    }
}