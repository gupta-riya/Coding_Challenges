// order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

// order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.

// Return any permutation of str (as a string) that satisfies this property.

class Solution {
    public String customSortString(String order, String str) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i =  0; i < str.length() ; i++)
        {
            char ch = str.charAt(i);
            
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        String ans = "";
        for(int i = 0 ; i < order.length();  i++)
        {
            char ch = order.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch) > 0)
            {
                for(int j = 0 ; j < hm.get(ch) ; j++)
                    ans += ch;
                
                hm.put(ch,0);
            }
        }
        
        for(int i =  0 ; i< str.length() ; i++)
        {
            char ch = str.charAt(i);
            if(hm.get(ch) > 0)
            {
                for(int j = 0 ; j < hm.get(ch) ; j++)
                    ans += ch;
                
                hm.put(ch,0);
            }
        }
        
        return ans;
    }
}
