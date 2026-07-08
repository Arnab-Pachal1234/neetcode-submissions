class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length-1;
        int ans = target[n];

        for (int i = n-1; i >=0; i--) {
            if (target[i] > target[i + 1]) {
                ans += target[i] - target[i + 1];
            }
        }

        return ans;
    }
}