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
// Time O(n) and Space - O(N−K+1) - Number of windows

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            // whole subarray has 0 to i sum k
            if ( prefixSum == k ){
                maxLength = Math.max(maxLength, i + 1);
            }
            // check if prefixSum - k seen before
            if ( map.containsKey(prefixSum - k) ){
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }
            // store prefixSum first occurence only and its index (in case of 0s)
            if ( !map.containsKey(prefixSum) ){
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}






