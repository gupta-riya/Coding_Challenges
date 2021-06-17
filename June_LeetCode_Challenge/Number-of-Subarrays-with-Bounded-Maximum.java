// We are given an array nums of positive integers, and two positive integers left and right (left <= right).

// Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least left and at most right.


class Solution {
    
    public long countsubarray(long n)
    {
        return (n*(n+1)/2);
    }
    
    
    
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        long res  = 0 ;
        
        int exc = 0 , inc = 0;
        
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] > right)
            {
                res += countsubarray(inc) - countsubarray(exc);
                exc = 0;
                inc = 0;
            }
            
            else if(nums[i] < left)
            {
                inc++;
                exc++;
            }
            
            else
            {
                  res -= countsubarray(exc);
                exc = 0;
                inc++;
            }
        }
        
        
         res += countsubarray(inc) - countsubarray(exc);
        
        return (int)res;
        
        
        
    }
}
