//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings.
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true


public boolean interLeave(String s1, String s2, String s3, HashMap<String,Boolean> map)
    {
        
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
            return true;
        
        if(s3.length()==0)
            return false;
        
        
        String key = (s1 + "|" + s2 + "|");
        
        if(!map.containsKey(key))
        {
            boolean x = (s1.length() != 0 && s1.charAt(0) == s3.charAt(0)) &&
                interLeave(s1.substring(1), s2, s3.substring(1),map);
 
        
 
            boolean y = (s2.length() != 0 && s2.charAt(0) == s3.charAt(0)) &&
                    interLeave(s1, s2.substring(1), s3.substring(1),map);
            
            map.put(key,x||y);

        }
        return map.get(key);
        
    }
    
    
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
       HashMap<String,Boolean> map = new HashMap<>(); 
       boolean check = interLeave(s1, s2, s3, map);
        return check;
        
    }
