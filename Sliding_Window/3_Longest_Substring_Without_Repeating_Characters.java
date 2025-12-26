// https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Naive One - Time -> O(n)cube

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int maxLength = 0;
        for (int i=0; i<s.length(); i++){
            for (int j=i; j<s.length(); j++){
                if (isUnique(s, i, j)){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    boolean isUnique(String s, int f, int l){

        boolean[] seen = new boolean[256]; // for all characters, size 256

        for (int i=f; i<=l; i++){
            char ch = s.charAt(i);

            if ( seen[ch] ){
                return false;
            }
            seen[ch] = true;
        }
        return true;
    }
}

// Optimized One - Time -> O(n)

class Solution {
    public int longestUniqueSubstr(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        int l =0;

        for (int r=0; r<s.length(); r++){
            char ch = s.charAt(r);

            while ( set.contains(ch) ){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(ch);

            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}

// Best One -> Time -> O(n)

class Solution {
    public int longestUniqueSubstr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0; int j = 0; int maxLength = 0;

        while ( j < s.length() ){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            // if map contains all unique characters
            // then map's size will always equal to the size of the window
            if ( map.size() == j - i + 1 ){
                maxLength = Math.max(maxLength, j - i + 1);
            }
            // when character repeat map's size will not increase so check < less than
            while ( map.size() < j - i + 1 ){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if ( map.get(s.charAt(i)) == 0 ){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }
}