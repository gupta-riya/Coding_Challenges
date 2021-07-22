// Given an array nums, partition it into two (contiguous) subarrays left and right so that:

// Every element in left is less than or equal to every element in right.
// left and right are non-empty.
// left has the smallest possible size.
// Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

class Solution {
    public int partitionDisjoint(int[] nums) {
        
        
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if( i == 0 )
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i-1],nums[i]);
        }
        
        for(int i = nums.length - 1 ; i >= 0 ; i--)
        {
            if( i == nums.length - 1 )
                right[i] = nums[i];
            else
                right[i] = Math.min(right[i+1],nums[i]);
        }
        
        for(int i = 0 ; i < nums.length-1 ; i++)
        {
            if(left[i] <= right[i+1])
                return i+1;
        }
        
        
        return nums.length;
        
        
        
        
    }
}
