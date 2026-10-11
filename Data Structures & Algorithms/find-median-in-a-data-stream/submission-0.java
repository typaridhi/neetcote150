class MedianFinder {

    PriorityQueue<Integer> left_maxHeap;
    PriorityQueue<Integer> right_minHeap;
    public MedianFinder() {
    left_maxHeap = new PriorityQueue <> (Collections.reverseOrder());
        right_minHeap = new PriorityQueue <> ();
    }
    
    public void addNum(int num) {
        if(left_maxHeap.isEmpty() || left_maxHeap.peek() >= num)
            left_maxHeap.add(num);
        else
            right_minHeap.add(num);
        if((left_maxHeap.size() - right_minHeap.size()) > 1)
    {
        right_minHeap.add(left_maxHeap.poll());
    }
    else if (right_minHeap.size() > left_maxHeap.size()) 
        left_maxHeap.add(right_minHeap.poll());

    }
    
    public double findMedian() {
        if(left_maxHeap.size() == right_minHeap.size())
        {
            double mean = ((double)left_maxHeap.peek() + right_minHeap.peek())/2;
            return mean;
        }
        return left_maxHeap.peek();
    }
}
