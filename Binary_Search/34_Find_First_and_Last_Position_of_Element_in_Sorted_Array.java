// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Time logn and constant sapce

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);
        int last = find(nums, target, false);

        return new int[]{first, last};
    }

    int find(int[] nums, int target, boolean findFirst){
        int ans = -1;
        int s = 0;
        int e = nums.length-1;

        while ( s<=e ){
            int m = s + (e-s)/2;

            if ( target == nums[m] ){
                ans = m;
                if ( (findFirst) ){
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else if ( target > nums[m] ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }
}