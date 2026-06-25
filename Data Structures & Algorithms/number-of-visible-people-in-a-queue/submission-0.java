class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            int el =heights[i];
            int cnt =0;
            while(!st.isEmpty() && st.peek()<el){
                cnt++;
                st.pop();
            }
            if(!st.isEmpty()) cnt++;
            ans[i]=cnt;
            st.push(el);
        }
        return ans;
    }
}