// Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

class Solution {
    
    
     
    boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while(i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }
        
    
    public List<List<Integer>> palindromePairs(String[] words) {
        
            List<List<Integer>> ans = new ArrayList();
        Map<String, Integer> map = new HashMap();
        
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }
        
        if (map.containsKey("")) {
            int idx = map.get("");
            for (int i = 0; i < words.length; ++i) {
                if (i != idx && isPalindrome(words[i])) {
                    ans.add(Arrays.asList(idx, i));
                    ans.add(Arrays.asList(i, idx));
                }
            }
        }
        
        for (int i = 0; i < words.length; ++i) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            Integer revIdx = map.get(rev);
            if (revIdx != null && revIdx != i) {
                ans.add(Arrays.asList(i, revIdx));
            }
        }
        
        for (int i = 0; i < words.length; ++i) {
            
            String cur = words[i];
            
            
            for (int cut = 1; cut < cur.length(); ++cut) {
                
                String left = cur.substring(0, cut);
                String right = cur.substring(cut);
                
                
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight)) {
                        ans.add(Arrays.asList(map.get(reversedRight), i));
                    }
                }
                
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)) {
                        ans.add(Arrays.asList(i, map.get(reversedLeft)));
                    }
                }
            }
        }
        return ans;
    }
   
}
