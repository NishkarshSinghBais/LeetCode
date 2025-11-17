// https://leetcode.com/problems/reverse-words-in-a-string/

class Solution {
    public String reverseWords(String s) {

        // Remove leading/trailing spaces and split by one or more spaces
        String[] str = s.trim().split(" +");

        // To build the reversed sentence efficiently
        StringBuilder sb = new StringBuilder();

        // Traverse the array from last word to first
        for (int i = str.length - 1; i >= 0; i--) {

            // Add the current word
            sb.append(str[i]);

            // Add space only if it's not the last word being added
            if (i > 0) {
                sb.append(" ");
            }
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }
}
