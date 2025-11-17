// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Naive One - Time -> O(n)cube

class Solution {

    // Returns the length of the longest substring without repeating characters
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;

        // Try every possible starting index i
        for (int i = 0; i < s.length(); i++) {

            // Try every possible ending index j (starting from i)
            for (int j = i; j < s.length(); j++) {

                // Check if substring s[i..j] has all unique characters
                if (isUnique(s, i, j)) {

                    // Update maximum length if current substring is longer
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }


    // Checks if characters between index f and l (inclusive) are all unique
    public boolean isUnique(String s, int f, int l) {

        // Boolean array to mark if a character has been seen
        boolean[] seen = new boolean[256]; // supports all ASCII chars

        // Traverse substring from f to l
        for (int i = f; i <= l; i++) {

            char c = s.charAt(i);

            // If this character is already seen, substring is not unique
            if (seen[c]) {
                return false;
            }

            // Mark character as seen
            seen[c] = true;
        }

        // No duplicates found
        return true;
    }
}

// Optimized One - Time -> O(2n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        HashSet<Character> set = new HashSet<>();

        // Left pointer of the sliding window
        int l = 0;

        // Variable to track the maximum length of substring found so far
        int maxLength = 0;

        // Iterate through the string with the right pointer
        for (int r = 0; r < s.length(); r++) {
            // Get the current character at the right pointer
            char ch = s.charAt(r);

            // If the character is already in the set, move the left pointer to the right
            // and remove characters from the set until the current character can be added
            while (set.contains(ch)) {
                set.remove(s.charAt(l)); // Remove the character at the left pointer
                l++; // Move left pointer to the right
            }

            // Add the current character to the set
            set.add(ch);

            // Update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, r - l + 1);
        }

        // Return the maximum length of the substring without repeating characters
        return maxLength;
    }
}

// Best One -> Time -> O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Map to store characters and their latest index in the string
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;        // Left pointer of sliding window
        int right = 0;       // Right pointer of sliding window
        int n = s.length();
        int maxLength = 0;   // Stores answer

        // Expand the window using the right pointer
        while (right < n) {

            char ch = s.charAt(right);

            // If character already exists in map
            // move left pointer to one position after its last occurrence
            // but we take max to ensure left never moves backwards
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            // Update the latest index of this character
            map.put(ch, right);

            // Calculate window length (current substring without repeating characters)
            maxLength = Math.max(maxLength, right - left + 1);

            // Move right pointer forward
            right++;
        }

        return maxLength;
    }
}


