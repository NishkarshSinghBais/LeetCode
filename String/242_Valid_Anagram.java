// https://leetcode.com/problems/valid-anagram/submissions/1833427089/
// Time - O(n)
// Space - O(1) The space does NOT grow when input grows.
// That’s the key point for O(1) space.
// int[] freq = new int[26]; Always have 26. No matter how long strings are.

class Solution {
    public boolean isAnagram(String s, String t) {

        int m = s.length();
        int n = t.length();

        if ( m != n ){
            return false;
        }
        int[] freq = new int[26];

        for (int i=0; i<m; i++ ){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int count : freq){
            if ( count != 0 ){
                return false;
            }
        }
        return true;
    }
}