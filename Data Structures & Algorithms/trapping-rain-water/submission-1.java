class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int presum[] = new int[n+1];
        presum[0]=0;
        for(int i=1;i<n;i++){
            presum[i]=presum[i-1]+height[i-1];
        }
        int s = 0,e = n-1;
        int sum =0;
        int leftmax = 0;
        int rightmax = 0;
        while(s<e){
            if(height[s]<=height[e]){
              if(height[s]>leftmax){
                leftmax= height[s];
              }
              else{
                sum += (leftmax - height[s]);
              }
              s++;

            }
            else{
                if(height[e]>rightmax){
                rightmax= height[e];
              }
              else{
                sum += (rightmax - height[e]);
              }
              e--;

            }
        }
        return sum;
    }
}
