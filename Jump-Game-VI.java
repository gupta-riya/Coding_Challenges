// You are given a 0-indexed integer array nums and an integer k.

// You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

// You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

// Return the maximum score you can get.


class Solution {
    
    public class Pair implements Comparable<Pair>{
        int val;
        int idx;
        Pair(int val, int idx)
        {
            this.val = val;
            this.idx = idx;
        }
        
        public int compareTo(Pair o)
        {
            return (o.val - this.val);
        }      
        
        
    }
    
    
    public int maxResult(int[] nums, int k) {
        
        if(nums.length==1)
            return nums[0];
        
        int n = nums.length;
        
        int dp[] = new int[n];
        dp[n-1] = nums[n-1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(dp[n-1],n-1));
        
        for(int i = n-2 ; i >= 0 ; i--)
        {
            while(pq.peek().idx > (i+k))
            {
                pq.remove();
            }
            
            dp[i] = nums[i] + pq.peek().val;
            
            pq.add(new Pair(dp[i],i));
            
        }
        
        return (int)dp[0];
    }
}
