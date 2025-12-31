// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

// Time - logn

class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while ( s <= e ){
            int m = s + (e-s)/2;
            if ( target == nums[m] ){
                return true;
            }
            if ( nums[m] == nums[s] && nums[m] == nums[e] ){
                s = s + 1;
                e =  e - 1;
                continue;
            }
            if ( nums[s] <= nums[m] ){ // if left half sorted
                if ( target <= nums[m] && target >= nums[s] ){
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else { // if right half sorted
                if ( target <= nums[e] && target >= nums[m] ){
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }
        return false;
    }
}