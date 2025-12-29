// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time logn and constant sapce

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        int s = 0;
        int e = nums.length-1;

        while ( s<=e ){
            int m = s + (e-s)/2;

            if ( target == nums[m] ){
                arr[0] = m;
                e = m - 1;
            } else if ( target < nums[m] ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        // Reset s and e before next loop
        s = 0;
        e = nums.length - 1;

        while ( s<=e ){
            int m = s + (e-s)/2;

            if ( target == nums[m] ){
                arr[1] = m;
                s = m + 1;
            } else if ( target < nums[m] ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return arr;
    }
}