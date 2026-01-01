// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

// Time - logn

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;

        if ( letters.length == 2 ){
            return letters[1];
        }
        char ans = letters[0];
        while ( s <= e ){
            int m = s + (e-s)/2;

            if ( letters[m] == target ){
                s = m + 1;
            }
            if ( letters[m] > target ){
                ans = letters[m];
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}