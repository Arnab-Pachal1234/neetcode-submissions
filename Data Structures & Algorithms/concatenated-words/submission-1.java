class Solution {
    HashMap<String,Boolean> dp;
    HashSet<String> set;
    boolean helper(String s){
        if(dp.containsKey(s)) return dp.get(s);
        
        for(int i=1;i<s.length();i++){

            if(set.contains(s.substring(0,i))){
               String next = s.substring(i);
               if(set.contains(next)){
                dp.put(s,true);
                
                return true;
               
               }
               else{
                boolean check = helper(next);
                if(check){
                    dp.put(s,true);
                    return true;
                   
                }
               }
            }
        }
        dp.put(s,false);
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.set = new HashSet<>();
        this.dp =  new HashMap<>();
        for(String w : words){
            set.add(w);
        }
        List<String> ans = new ArrayList<>();
        for(String w : words){
            if(helper(w)){
                ans.add(w);
            }
        }
        return ans;
    }
}