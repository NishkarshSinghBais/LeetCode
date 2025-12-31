// https://leetcode.com/problems/single-element-in-a-sorted-array/description/

// Time logn

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s = 1;
        int e = nums.length - 2;

        if ( nums.length == 1 ){
            return nums[0];
        }
        // Check for 1st and Last element in advance.
        if ( nums[s-1] != nums[s] ){
            return nums[s-1];
        }

        if ( nums[e+1] != nums[e] ){
            return nums[e+1];
        }

        while ( s <= e ){
            int m = s + (e-s)/2;

            if ( nums[m] != nums[m-1] && nums[m] != nums[m+1] ){
                return nums[m];
            }
            // This is the point to remember
            if ( m % 2 == 1 && nums[m] == nums[m-1] || m % 2 == 0 && nums[m] != nums[m-1] ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}