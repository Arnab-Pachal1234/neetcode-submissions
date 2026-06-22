class Solution {
    int atMost(int [] nums,int k){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int right = 0,left =0, n = nums.length;
        int cnt =0;
        while(right<n){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
            while(left<=right && freq.size()>k){
                int l = nums[left];
                if(freq.get(l)==1){
                    freq.remove(l);
                }
                else{
                    freq.put(l,freq.get(l)-1);
                }
                left++;
            }
            cnt += (right-left+1);
            right++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
}