// https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

// Brute Force - Time - 0(n)square and Space - 0(k)

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int maxLength = -1;

        for (int i=0; i<s.length(); i++){
            Map<Character, Integer> map = new HashMap<>();
            for (int j=i; j<s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() == k){
                    maxLength = Math.max(maxLength, j - i + 1);
                }

                if ( map.size() > k ){
                    break;
                }
            }
        }
        return maxLength;
    }
}


// Better Approach - Time - 0(n) and Space - 0(k)

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i = 0;
        int j = 0;
        int maxLength = -1;
        Map<Character, Integer> map = new HashMap<>();

        while ( j < s.length() ){
            // if char exist value + 1, else start with 1
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if ( map.size() == k ){
                maxLength = Math.max(maxLength, j - i + 1);

            }
            while ( map.size() > k ){
                // Reduce i's char count if exist
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                // Remove key if count == 0;
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