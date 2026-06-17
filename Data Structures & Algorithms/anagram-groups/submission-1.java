class Solution {
    String build(String st){
        int freq[] = new int[26];
        for(int i=0;i<st.length();i++){
            freq[st.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<25;i++){
            sb.append(freq[i]+"|");
        }
        sb.append(freq[25]);
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            String key = build(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                map.put(key,new ArrayList<>());
                map.get(key).add(str);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> curr = new ArrayList<>(map.get(key));
            ans.add(curr);
        }
        return ans;
    }
}
