class Solution {
    HashMap<Integer,HashSet<String>>dp;
    HashSet<String> set;
    String s;
    HashSet<String> memo(int i){
        if(i==s.length()){
            HashSet<String> store = new HashSet<>();
            store.add("");
            return store;
        }
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        HashSet<String> res = new HashSet<>();
      
        for(int j=i+1;j<=s.length();j++){
            if(set.contains(s.substring(i,j))){
                HashSet<String> next = memo(j);
                for(String el : next){
                    res.add(s.substring(i,j)+" "+el);
                }
            }
        }
        dp.put(i,res);
        return res;

    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        this.s = s;
        this.set = new HashSet<>();
        for(String el : wordDict){
            set.add(el);
        }
        HashSet<String> finalres = memo(0);
        List<String> res = new ArrayList<>();
        for(String  el : finalres){
            res.add(el.trim());
        }
        return res;
    }
}