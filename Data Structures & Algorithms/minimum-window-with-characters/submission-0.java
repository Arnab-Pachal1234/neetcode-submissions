class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        HashMap<Character,Integer> freq = new HashMap<>();
        for(Character c : t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int actualunique = freq.size();
        HashMap<Character,Integer> curr = new HashMap<>();
        int left =0,right = 0;
        int len = Integer.MAX_VALUE;
        String ans = "";
        int currunique = 0;
        while(right<n){
            char now = s.charAt(right);
            curr.put(now,curr.getOrDefault(now,0)+1);
            if(freq.getOrDefault(now,0)==curr.get(now)){
                currunique++;
            }
            while(left<=right && currunique == actualunique){
                int currlen = right-left+1;
                if(currlen<len){
                    len = currlen;
                    ans = s.substring(left,right+1);
                }
                char l = s.charAt(left);
                curr.put(l,curr.get(l)-1);
                if(freq.containsKey(l) && freq.get(l)>curr.get(l)){
                    currunique--;
                }
                left++;

            }
            right++;


        }
        return ans;

    }
}
