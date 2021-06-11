// Alice and Bob take turns playing a game, with Alice starting first.

// There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

// Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.

// Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.

class Solution {
    public int stoneGameVII(int[] stones) {
        
        int len = stones.length;
        
        int[] prefixsum = new int[len];
        
        prefixsum[0] = stones[0];
        
        for (int i = 1; i < len; i++)
            prefixsum[i] = prefixsum[i - 1] + stones[i];
        
        int[][] dp = new int[len][len];
        
        for (int i = len - 2; i >= 0; i--) {
            
            for (int j = i + 1; j < len; j++)
            {
                dp[i][j] = Math.max(getRangeSum(prefixsum, i + 1, j) - dp[i + 1][j], getRangeSum(prefixsum, i, j - 1) - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }

    public int getRangeSum(int[] prefixsum, int start, int end) {
        return start == 0 ? prefixsum[end] : prefixsum[end] - prefixsum[start - 1];
    }
}
