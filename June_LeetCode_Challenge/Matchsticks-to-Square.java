// You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

// Return true if you can make this square and false otherwise.


class Solution {
    
    public boolean canMakeSquares(int[] matchsticks,int target, int ind,int[] sides)
    {
        if(ind==matchsticks.length)
        {
            
            for(int i = 1 ; i < 4 ; i++)
            {
                if(sides[i]!=target)
                    return false;
            }
            
            return true;
        }
        
        
        for(int i = 0 ; i < 4 ; i++ )
        {
            if(sides[i]+matchsticks[ind] <= target)
            {
                sides[i]+= matchsticks[ind];
                boolean check = canMakeSquares(matchsticks,target,ind+1,sides);
                if(check)
                    return true;
                sides[i]-= matchsticks[ind];
              
            }
        }
        
        
        return false;
    }
    
    
    
    
    public boolean makesquare(int[] matchsticks) {
        
        
        int[] sides = new int[4];
        
        int count = 0 ;
        for(int i = 0 ; i < matchsticks.length ; i++)
        {
            count += matchsticks[i];
        }
        
        if(count%4!=0)
            return false;
        
        return canMakeSquares(matchsticks,count/4,0,sides);
        
    }
}
