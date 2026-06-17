class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int left[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty())left[i]=-1;
            else left[i]=st.peek();
            st.push(i);
        }
        int right[] = new int[n];
        st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            
            while(!st.isEmpty() &&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()) right[i]=n;
            else right[i]=st.peek();
            st.push(i);
        }
        int maxarea = 0;
        for(int i=0;i<n;i++){
            maxarea = Math.max(maxarea,nums[i]*(right[i]-left[i]-1));
        }
        return maxarea;
    }
}
