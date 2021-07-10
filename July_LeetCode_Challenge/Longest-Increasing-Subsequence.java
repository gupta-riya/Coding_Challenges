// Given an integer array nums, return the length of the longest strictly increasing subsequence.

// A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


class Solution {
    public int lengthOfLIS(int[] arr) {
        
        
        
        int dp[] = new int[arr.length];
        
        dp[0] = 1;
        
        int res = 1;
        
        for(int i =  1 ; i < arr.length ; i++)
        {
            int max = 1;
            for(int j = 0 ; j < i ; j++)
            {
                if(arr[j] < arr[i])
                    max = Math.max(max,dp[j]+1);
            }
            
            dp[i] = max;
            if(res < dp[i])
                res = dp[i];
        }
        
        return res;
        
    }
}
