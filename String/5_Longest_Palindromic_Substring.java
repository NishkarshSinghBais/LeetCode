// https://leetcode.com/problems/longest-palindromic-substring/
// Time -> O(n)square

class Solution {
    public String longestPalindrome(String s) {
        if ( s.length() <= 1 ){
            return s;
        }

        String LPS = "";

        for (int i=0; i<s.length(); i++){

            String odd = expand(s, i, i);
            if ( odd.length() > LPS.length() ){
                LPS = odd;
            }
            String even = expand(s, i, i+1);
            if ( even.length() > LPS.length() ){
                LPS = even;
            }
        }
        return LPS;
    }
    public String expand(String s, int a, int b){
        while ( a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b) ){
            a--;
            b++;
        }
        return s.substring(a + 1, b);
    }
}