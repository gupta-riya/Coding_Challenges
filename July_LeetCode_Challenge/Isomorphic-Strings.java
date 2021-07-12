// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.


class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        
        if(s.length()!=t.length())
            return false;
        
        if(s.length()==1)
            return true;
            
        HashMap<Character,Character> hmap = new HashMap<>();
        HashMap<Character,Character> hmap2 = new HashMap<>();
        
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            
            if(hmap.containsKey(ch2))
            {
                if(hmap.get(ch2) != ch1)
                    return false;
            }
            
            if(hmap2.containsKey(ch1))
            {
                if(hmap2.get(ch1) != ch2)
                    return false;
            }
            
            if(!hmap.containsKey(ch2) && !hmap2.containsKey(ch1))
            {
                hmap.put(ch2,ch1);
                hmap2.put(ch1,ch2);
            }
            
            
        }
        
        
        
        return true;
        
        
        
    }
}
