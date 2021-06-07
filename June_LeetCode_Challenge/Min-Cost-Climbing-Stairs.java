// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        
        
        int[] dp = new int[cost.length + 1];
        
        dp[dp.length-1] = 0;
        
        for(int i = dp.length - 2 ; i >= 0 ; i-- )
        {
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j < 3 && (i+j) < dp.length ; j++ )
            {
                min = Math.min(min,dp[i+j]);
            }
            dp[i] = min+cost[i];
        }
        
        return Math.min(dp[0],dp[1]);
        
        
        
        
    }
}
