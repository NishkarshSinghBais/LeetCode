// https://leetcode.com/problems/maximum-subarray/description/

// Brute Force - O(n)square

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            int sum = 0;
            for (int j=i; j<nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

// Kadane's Algorithm - O(n)

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;

        while ( i < nums.length ){


            sum += nums[i];
            maxSum = Math.max(maxSum, sum);

            // If sum becomes negative, it cannot contribute to any max subarray
            // so discard it and avoid carrying a negative running sum into the future
            if ( sum < 0 ){
                sum = 0;
            }
            i++;
        }
        return maxSum;
    }
}