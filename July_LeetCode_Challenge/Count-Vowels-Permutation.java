// Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

// -Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
// -Each vowel 'a' may only be followed by an 'e'.
// -Each vowel 'e' may only be followed by an 'a' or an 'i'.
// -Each vowel 'i' may not be followed by another 'i'.
// -Each vowel 'o' may only be followed by an 'i' or a 'u'.
// -Each vowel 'u' may only be followed by an 'a'.
// Since the answer may be too large, return it modulo 10^9 + 7.


class Solution {
    public int countVowelPermutation(int n) {
        
        
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        
        
       for(int i = 0 ; i < 5 ; i++)
           hm.put(i,new ArrayList<>());
        
        //a
        hm.get(0).add(1);
        hm.get(0).add(2);
        hm.get(0).add(4);

        //e
        hm.get(1).add(0);
        hm.get(1).add(2);
        
        //i
        hm.get(2).add(1);
        hm.get(2).add(3);
        
        //o
        hm.get(3).add(2);
                
        //u
        hm.get(4).add(2);
        hm.get(4).add(3);
        
        
        
        int dp[][] = new int[n+1][5];

        for(int i =  1 ; i <= n ; i++)
        {
            for(int j = 0 ; j < 5 ; j++)
            {
                if(i==1)
                    dp[i][j] = 1;
                else
                {
                    ArrayList<Integer> l = hm.get(j);
                    for(Integer k : l)
                    {
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%1000000007;
                    }
                }
            }
        }
        
        int total = 0;
        for(int j =  0 ; j < 5 ; j++)
            total = (total + dp[n][j])%1000000007;
        
        
        return total%1000000007;

        
    }
}
