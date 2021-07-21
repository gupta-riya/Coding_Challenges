// There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

// After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

// For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

// You are given a string dominoes representing the initial state where:

// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
// Return a string representing the final state.


class Solution {
    public String pushDominoes(String dominoes) {
        
        
        int n = dominoes.length();
        
        
        int left[] = new int[n];
        int right[] = new int[n];
        
        
        int idx = -1;
        
        for(int i = 0 ; i < n ; i++)
        {
            char ch = dominoes.charAt(i);
            if(ch == 'L')
                idx = -1;
            else if(ch == 'R')
                idx = i;
            
            if(idx == -1)
                right[i] = n;
            else
                right[i] = i - idx;
            
        }
        
        idx = -1;
        
        for(int i = n-1 ; i >= 0 ; i--)
        {
            char ch = dominoes.charAt(i);
            if(ch == 'L')
                idx = i;
            else if(ch == 'R')
                idx = -1;
            
            if(idx == -1)
                left[i] = n;
            else
                left[i] = idx - i;
            
        }
        
        
        StringBuilder ans = new StringBuilder("");
        
        for(int i = 0 ; i < n ; i++)
        {
            
            char ch = dominoes.charAt(i);
            
            if(left[i]==right[i])
                ans.append(""+ch);
            
            else if(right[i] < left[i])
                ans.append("R");
            
            else
               ans.append("L");
           
        }
        
        
        
       return ans.toString(); 
        
        
        
        
    }
}
