
//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int dp[][] = new int[n1+1][n2+1];
        
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                if(nums1[i-1]==nums2[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = 0;
                
                if(dp[i][j] > max)
                    max = dp[i][j];
            }
        }        
        
        return max;
        
        
    }
}
