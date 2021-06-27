// There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// Return the minimum number of candies you need to have to distribute the candies to the children.

class Solution {
    public int candy(int[] ratings) {
        
        
        if(ratings.length==1)
            return 1;
        
        int n = ratings.length;
        
        int leftcandy[] = new int[n];
        int rightcandy[]=  new int[n];
        
       
        for(int i = 0 ; i < n ; i++)
        {
            if(i==0)
            {
               leftcandy[i]=1;
            }
            else
            {
                if(ratings[i-1]<ratings[i])
                    leftcandy[i] = leftcandy[i-1]+1;
                else
                    leftcandy[i] = 1;
            }
        }
        
        
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(i==n-1)
            {
               rightcandy[i]=1;
            }
            else
            {
                if(ratings[i+1]<ratings[i])
                    rightcandy[i] = rightcandy[i+1]+1;
                else
                    rightcandy[i] = 1;
            }
        }
        
        int sum = 0;
        for(int i= 0 ; i < n ; i++)
            sum += Math.max(leftcandy[i],rightcandy[i]);
        
        
        return sum;
        
    }
}
