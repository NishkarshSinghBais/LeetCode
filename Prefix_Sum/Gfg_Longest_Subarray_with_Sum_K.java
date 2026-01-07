// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

// Brute Force - O(n)square

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int maxLength = 0;
        for (int i=0; i<arr.length; i++){
            int sum = 0;
            for (int j=i; j<arr.length; j++){
                sum = sum + arr[j];
                if ( sum == k ){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}

// Better Approach - Prefix Sum
// Time O(n) and Space - O(n) - Number of windows

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            if ( prefixSum == k ){
                maxLength = Math.max(maxLength, i + 1);
            }
            // check if prefixSum - k seen before
            if ( map.containsKey(prefixSum - k) ){
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }
            // store only prefixSum first occurence and its index (in case of 0s)
            if ( !map.containsKey(prefixSum) ){
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}

// If Arrays Contains only Positives - Sliding Window O(n) Approach

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int i = 0; int j=0; int sum = 0; int length = 0;

        while ( j<arr.length ){
            sum += arr[j];

            if ( sum == k ){
                length = Math.max(length, j-i+1);
            }

            while ( sum > k ){
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return length;
    }
}






