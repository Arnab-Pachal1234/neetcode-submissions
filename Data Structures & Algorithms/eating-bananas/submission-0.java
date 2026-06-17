class Solution {
    boolean isPossible(int[] piles,int h ,int mid)
    {
        int cnt =0;
        for(int p : piles)
        {
            cnt+=(p/mid);
            if((p%mid)!=0) cnt++;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxvalue = Integer.MIN_VALUE;
        for(int p : piles) maxvalue=Math.max(maxvalue,p);
        int min =1,max = maxvalue;
        int ans = maxvalue;
        while(min<=max)
        {
            int mid = min + (max-min)/2;
            if(isPossible(piles,h,mid))
            {
                ans = mid;
                max = mid-1;
            }
            else
            {
                min = mid+1;
            }
        }
        return ans;
    }
}
