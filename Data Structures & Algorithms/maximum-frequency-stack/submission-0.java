class FreqStack {
     HashMap<Integer,Integer> dup = new HashMap<>();
     int maxfreq =0;
     HashMap<Integer,Stack<Integer>> freqst = new HashMap<>();
    public FreqStack() {
        
    }

    public void push(int val) {
        int prev = dup.getOrDefault(val,0);
        int newfreq = prev+1;
        if(!freqst.containsKey(newfreq)){
            freqst.put(newfreq,new Stack<>());
        }
        freqst.get(newfreq).push(val);
        dup.put(val , newfreq);
    
        if(newfreq>maxfreq){
            maxfreq = newfreq;
        }
    }
    
    public int pop() {
        if(freqst.get(maxfreq).isEmpty()) return -1;
        int el = freqst.get(maxfreq).pop();
        dup.put(el,dup.get(el)-1);
        if(freqst.get(maxfreq).isEmpty()){
            maxfreq = maxfreq-1;
        }
        return el;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */