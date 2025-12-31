// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

// Time - logn

class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int n = nums.length;

        if ( nums[s] <= nums[e] ){
            return nums[s];
        }

        while ( s <= e ){
            int m = s + (e-s)/2;
            int l = (m+n-1)%n;
            int r = (m+1)%n;

            if ( nums[m] < nums[l] && nums[m] < nums[r] ){
                return nums[m];
            }
            if ( nums[m] < nums[e] ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}