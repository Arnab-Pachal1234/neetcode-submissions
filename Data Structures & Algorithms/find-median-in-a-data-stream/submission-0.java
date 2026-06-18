class MedianFinder {

    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());

        if(minheap.size()>maxheap.size()){
            maxheap.add(minheap.poll());
        }

    }
    
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            return maxheap.peek(); // Odd number of elements
        }
        // Even number of elements
        return (maxheap.peek() + minheap.peek()) / 2.0;
    }
}
