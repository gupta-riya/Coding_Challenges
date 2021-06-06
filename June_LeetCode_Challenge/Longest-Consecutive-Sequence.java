// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

class Solution {
    public int longestConsecutive(int[] nums) {
        
        
        if(nums.length==0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            pq.add(nums[i]);
            
        }
        
        int max = 1;
        int c = 1;
        int prev = pq.remove();
        for(int i = 1 ; i < nums.length ; i++)
        {
            if(pq.peek() - prev > 1)
            {
                c = 1;
                
                
            }
            else if(pq.peek() - prev == 0)
            {
                
            }
            else
            {
                c++;
            }
            
            prev = pq.remove();
            
            
            if(c > max)
                max = c;
        }
        
        return max;
  
        
    }
}
