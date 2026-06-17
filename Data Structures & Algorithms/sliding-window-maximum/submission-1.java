
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            else{return b[1]-a[1];}
        });
        for(int i=0;i<k;i++){
            pq.add(new int[]{i,nums[i]});
        }
        ans[0]=pq.peek()[1];

        
        for(int i=k;i<n;i++){
            pq.add(new int[]{i,nums[i]});
            while(!pq.isEmpty() && i-pq.peek()[0]+1>k){
                pq.poll();
            }
            if(pq.isEmpty()){ans[i-k+1]=-1;}
            ans[i-k+1]=pq.peek()[1];
        }
        return ans;
    }
}
