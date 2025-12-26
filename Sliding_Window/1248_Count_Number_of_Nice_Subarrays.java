// https://leetcode.com/problems/count-number-of-nice-subarrays/description/

// Brute Force - Time O(n)square

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int totalSubarrays = 0;

        for (int i=0; i<nums.length; i++){
            int count = 0;
            for (int j=i; j<nums.length; j++){
                if ( nums[j] % 2 != 0 ){
                    count++;
                }

                if ( count == k ){
                    totalSubarrays++;
                }
            }
        }
        return totalSubarrays;
    }
}

// Sliding Window - O(n)

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // Rule -> count subarray with exactly K something
        // but that "something" is monotonic/non-negative
        // then use this formula
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    public int countAtMost(int[] nums, int k){

        int i = 0;
        int j = 0;
        int count = 0;
        int totalSubarrays = 0;

        while ( j < nums.length ){

            if ( nums[j] % 2 != 0 ){
                count++;
            }

            while ( count > k ){
                if ( nums[i] % 2 != 0 ){
                    count--;
                }
                i++;
            }
            // count all subarrays <= k
            totalSubarrays += j - i + 1;
            j++;
        }
        return totalSubarrays;
    }
}

