// https://leetcode.com/problems/longest-repeating-character-replacement/description/

// Brute Force - Time -> O(n)square and Space -> Constant

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;

        for (int i=0; i<s.length(); i++){
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int j=i; j<s.length(); j++){
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

                if ( (j - i + 1) - maxFreq <= k ){
                    maxLength = Math.max(maxLength, j - i + 1);00
                }
            }
        }
        return maxLength;
    }
}

// Sliding Window - Time O(n) (Best Approach) Using Frequency Array

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        while ( j < s.length() ){
            freq[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

            if ( (j-i+1) - maxFreq <= k ){
                maxLength = Math.max(maxLength, j-i+1);
            }

            while ( (j-i+1) - maxFreq > k){
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            j++;
        }
        return maxLength;
    }
}


// Sliding Window - Time O(n) -> Using HashMap (Slightly Slower Because of HashMap)

class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while ( j < s.length() ){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(j)));

            if ( (j-i+1) - maxFreq <= k ){
                maxLength = Math.max(maxLength, j-i+1);
            }

            while ( (j-i+1) - maxFreq > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return maxLength;
    }
}