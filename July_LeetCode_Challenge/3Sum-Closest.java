// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

class Solution {
    public int threeSumClosest(int[] arr, int target) {
        
         Arrays.sort(arr);
        
        int i = 0, minSum = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        
        while(i < arr.length-2)
        {
            
            int vali = arr[i];
            
            int j = i+1, k = arr.length-1;
            
            while(j < k)
            {
                int sum = vali + arr[j] + arr[k];
                
                int diff = (int)Math.abs(sum-target);
                
                if(diff < minDiff)
                {
                    minDiff = diff;
                    minSum = sum;                        
                }
                    
                if(sum == target)
                    break;
                
                else if(sum < target)
                    j++;
                
                else if(sum > target)
                    k--;
                
                
            }
            
            
            while(i < arr.length-2 && arr[i] == vali)
                i++;
            
            
        }
        
        
        return minSum;
        
        
    }
}
