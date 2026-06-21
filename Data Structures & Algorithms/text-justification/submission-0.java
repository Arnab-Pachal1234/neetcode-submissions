class Solution {
    String generateSpaces(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(" ");

        }
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int  n = words.length;
        int len[] = new int[n];
        for(int i=0;i<words.length;i++){
            len[i]=words[i].length();
        }
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<n){
            int cnt =0;
            int rem = maxWidth;
            int j =i;
            boolean leftjustified = false;
            int totalspacesneeded =0;
            while(j<n &&  words[j].length()<=rem){
                totalspacesneeded+=words[j].length();
                rem-=words[j].length();
                //extra space for each word
                rem-=1;
                cnt++;
                if(j==n-1) leftjustified = true;
                j++;
            }
            int extraspaces = maxWidth - totalspacesneeded;
            if(cnt==1){
                String remspaces = generateSpaces(extraspaces);
                String curr = words[i]+remspaces;
                ans.add(curr);
            }
            else{
              
                int equalspaces = (maxWidth-totalspacesneeded);
                int mod = equalspaces % (cnt-1);
                int even = equalspaces / (cnt-1);
                StringBuilder curr = new StringBuilder();
                  if(!leftjustified){
                for(int k=0;k<cnt;k++){
                    
                    curr.append(words[i+k]);
                    if(k!=cnt-1){
                        if(mod>0){
                            curr.append(generateSpaces(even+1));
                            mod--;
                        }
                        else{
                            curr.append(generateSpaces(even));
                        }
                    }
                }
                }
                else{
                    for(int k=0;k<cnt;k++){
                    
                    curr.append(words[i+k]);
                    if(k!=cnt-1) curr.append(" ");
                }
                int remspaces = equalspaces-(cnt-1);
                curr.append(generateSpaces(remspaces));
                }

                ans.add(curr.toString());
            }
            i=j;
        
        }
        return ans;
       
    }
}