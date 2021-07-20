// Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

// Implement the Solution class:

// Solution(int[] nums) Initializes the object with the integer array nums.
// int[] reset() Resets the array to its original configuration and returns it.
// int[] shuffle() Returns a random shuffling of the array.
 
class Solution {

    
    public int[] arr;
    public Random random;
    
    public Solution(int[] nums) {
       arr = nums;
       random = new Random();
       
        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        
        return arr;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        
        int res[] = new int[arr.length];
        res = arr.clone();
       
            
        for(int i = arr.length-1 ; i >0 ; i--)
        {
            int idx = random.nextInt(i+1);
            int temp = res[idx];
            res[idx] = res[i];
            res[i] = temp;
        }
        
       
        return res;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
