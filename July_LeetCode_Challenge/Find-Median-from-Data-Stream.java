// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:

// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxHeap,minHeap;
    double median;
    int size;
    
    public MedianFinder() {
        
        maxHeap = new PriorityQueue<>((a,b)->{return b-a;});
        minHeap = new PriorityQueue<>();
        median = 0.0;    
        size = 0;
        
    }
    
    public void addNum(int num) {
        
        int maxsize = maxHeap.size();
        int minsize = minHeap.size();
        
        if( maxsize == 0)
            maxHeap.add(num);
        else if(maxsize == minsize)
        {
            if(num < minHeap.peek())
                maxHeap.add(num);
            else
            {
                maxHeap.add(minHeap.remove());
                minHeap.add(num);
            }
                   
                  
        }
        else
        {
            if(minsize == 0)
            {
                if(num > maxHeap.peek())
                    minHeap.add(num);
                else
                {
                   minHeap.add(maxHeap.remove());
                    maxHeap.add(num); 
                }
            }
            else if(num >= minHeap.peek())
            {
                minHeap.add(num);
            }
            else
            {
                if(num < maxHeap.peek())
                {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }
                else
                {
                    minHeap.add(num);
                }
            }
        }
            

        size++;  
        
    }
    
    public double findMedian() {
        
        
        if(size%2==0)
        {
            return ((maxHeap.peek()+minHeap.peek())/2.0);
        }
        else
        {
            return maxHeap.peek();
        }
        
        
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
