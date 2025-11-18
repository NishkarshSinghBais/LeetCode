// https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

// Brute Force - O(n*k)

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<=arr.length-k; i++){
            int sum = 0;
            for (int j=i; j<i+k; j++){
                sum = sum + arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}

// Sliding Window - O(n)

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while ( j < arr.length ){
            sum = sum + arr[j];

            if ( j - i + 1 < k ){
                j++;
            } else if ( j - i + 1 == k ){
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}