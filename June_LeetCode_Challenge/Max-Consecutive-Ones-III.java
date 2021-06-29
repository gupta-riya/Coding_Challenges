// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.


class Solution {
    public int longestOnes(int[] nums, int k) {
        
        
        int i =  0 , j = 0, len = 0 , m = 0 , n = nums.length;
        int res = 0;
        
        while(i <= j && j < n)
        {
            
            if(nums[j]==1)
            {
                len++;
                j++;
            }
            else
            {
                if(m < k)
                {
                   j++;
                   len++; 
                }
                else
                {
                    if(nums[i]==0)
                    {
                        i++;
                        j++;
                        m--;
                    }
                    else
                    {
                      i++;
                      len--;
                    }
                }
                m++;
                
            }
            if(len > res)
                res = len; 
         
        }
        
        
        
        
        return res; 
        
    }
}
