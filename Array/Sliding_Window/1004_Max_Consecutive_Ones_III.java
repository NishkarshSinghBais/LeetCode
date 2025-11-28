// https://leetcode.com/problems/max-consecutive-ones-iii/description/

// think of it like find the Largest Subarray which contains at most 2 zeroes

// Brute Force - O(n)square
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;

        for(int i=0; i<nums.length; i++){
            int countZero = 0;
            for (int j=i; j<nums.length; j++){
                if ( nums[j] == 0 ){
                    countZero++;
                }
                if ( countZero <= k ){
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
}

// Sliding Window - Time -> O(n) and Constant Space

class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while ( j < nums.length ){
            if ( nums[j] == 0 ){
                zeroCount++;
            }

            if ( zeroCount <= k ){
                maxLength = Math.max(maxLength, j - i + 1);
            }

            while ( zeroCount > k ){
                if ( nums[i] == 0 ){
                    zeroCount--;
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }
}