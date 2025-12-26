// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

// brute Force - O(n)square

class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;

        for (int i=0; i<s.length(); i++){

            int[] freq = new int[3];

            for (int j=i; j<s.length(); j++){

                freq[s.charAt(j) - 'a'] = 1;

                if ( freq[0] + freq[1] + freq[2] == 3 ){
                    // Because abcaaaa contains more substring past abc,
                    // have to include before break
                    // (n-1) - j + 1 = n - j where n is s.length()
                    count += s.length() - j;
                    break;
                }
            }
        }
        return count;
    }
}

// Sliding Window - O(n)

class Solution {
    public int numberOfSubstrings(String s) {

        int count = 0;
        int j = 0;
        int[] idx = {-1, -1, -1};

        while ( j < s.length() ){
            // update the last seen index of current character
            idx[s.charAt(j) - 'a'] = j;

            if ( idx[0] != -1 && idx[1] != -1 && idx[2] != -1 ){
                // Find the earliest among the last seen indices of a, b, c
                // This index is farthest left we can go while having a valid substring
                // Math.min(idx[0], Math.min(idx[1], idx[2])) this thing will do this
                // adding 1 to earliest will give, number of valid substrings
                // dry run man on "abcabc", u will get
                // like this (min(0,1,2) + 1) + (min(3,1,2) + 1)+... till last index.
                count += Math.min(idx[0], Math.min(idx[1], idx[2])) + 1;
            }
            j++;
        }
        return count;
    }
}