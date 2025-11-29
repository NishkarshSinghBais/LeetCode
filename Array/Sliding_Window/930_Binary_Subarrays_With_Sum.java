// https://leetcode.com/problems/binary-subarrays-with-sum/description/

// Brute Force - Time O(n)square

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int maxNum = 0;
        for (int i=0; i<nums.length; i++){
            int sum = 0;
            for (int j=i; j<nums.length; j++){
                sum += nums[j];
                if ( sum == goal ){
                    maxNum++;
                }
            }
        }
        return maxNum;
    }
}

// Sliding Window - O(n)

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }
    public int countAtMost(int[] nums, int goal){

        // there will be no subarray less than zero (binary array 0s and 1s only)
        // withou this check, the sliding window would shrink infinitely because
        // sum > goal (0 > -1) is always true.
        // that will move 'i' beyond array bounds and cause IndexOutOfBoundsException.
        if ( goal < 0 ){
            return 0;
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;

        while ( j < nums.length ){
            sum += nums[j];

            // shrink first, point to remember
            while ( sum > goal ){
                sum -= nums[i];
                i++;
            }
            // Can't check before shrinking
            // to know why dry run with program flow on [1,0,1] and goal = 1

            count += j - i + 1;

            j++;
        }
        return count;
    }
}
