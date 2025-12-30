// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// Time - O(logn) + O(logn) = O(logn) and constant space

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findMin(nums);
        int first = binarySearch(0, pivot - 1, nums, target);
        int second = binarySearch(pivot, n-1, nums, target);

        return Math.max(first, second);
    }
    int binarySearch(int s, int e, int[] nums, int target){
        while ( s <= e ){
            int m = s + (e - s)/2;

            if ( target == nums[m] ){
                return m;
            } else if ( target > nums[m] ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }

    int findMin(int[] nums){
        int s = 0;
        int e = nums.length - 1;
        int n = nums.length;

        while ( s <= e ){
            int m = s + (e - s)/2;
            int l = (m+n-1)%n;
            int r = (m+1)%n;

            if ( nums[m] <= nums[l] && nums[m] <= nums[r] ){
                return m;
            }
            if ( nums[m] <= nums[e] ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return 0;
    }
}

// In a Single Pass - Prefer This One

class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while ( s <= e ){
            int m = s + (e-s)/2;
            if ( target == nums[m] ){
                return m;
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
        return -1;
    }
}