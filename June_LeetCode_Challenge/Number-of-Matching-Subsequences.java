// Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".



class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int res = 0;

        Map<String, Boolean> cache = new HashMap<>();

        for (String word : words) {
            if (word.length() > s.length()) continue;

            if (isSubsequence(word, s, cache)) {
                ++res;
            }
        }
        return res;
    }

    public boolean isSubsequence(String word, String S, Map<String, Boolean> cache) {
        if (cache.get(word) != null) {
            return cache.get(word);
        }

        int index = -1;
        for (char c : word.toCharArray()) {
            index = S.indexOf(c, index + 1);

            if (index == -1) {
                cache.put(word, false);
                return false;
            }
        }
        cache.put(word, true);
        return true;
    
    }
}
