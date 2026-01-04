// https://leetcode.com/problems/reverse-string-prefix/description/

class Solution {
    public String reversePrefix(String s, int k) {

        if ( k == 0 || k > s.length() ){
            return s;
        }

        String prefix = s.substring(0, k);
        String suffix = s.substring(k, s.length());

        StringBuilder sb = new StringBuilder();

        for (int i=prefix.length() - 1; i>=0; i--){
            sb.append(prefix.charAt(i));
        }
        sb.append(suffix);
        return sb.toString();
    }
}