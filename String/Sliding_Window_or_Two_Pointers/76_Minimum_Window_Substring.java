// https://leetcode.com/problems/minimum-window-substring/description/

// Sliding Window - Time -> O(n) and Space -> O(k) (k = No. of unique chars in t)


class Solution {
    public String minWindow(String s, String t) {
        // First of all, Store all the chars of t and its frequency in map
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int sIdx = 0;

        // for count++/-- confusion dry run s="ddaaabbca", t="abc" - make a map and...
        while ( j < s.length() ){
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if ( map.get(s.charAt(j)) >= 0 ){
                    count++;
                }
            }
            while ( count == t.length() ){
                // first check if new length is smaller than previous window
                if ( j - i + 1 < minLength ){
                    // then update these two, it will help in getting the min substring
                    sIdx = i;
                    minLength = j - i + 1;
                }
                if ( map.containsKey(s.charAt(i)) ){
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if ( map.get(s.charAt(i)) > 0){
                        count--;
                    }
                }
                i++;
            }
            j++;
        }
        return (minLength == Integer.MAX_VALUE) ? "" : (s.substring(sIdx, sIdx + minLength));
    }
}