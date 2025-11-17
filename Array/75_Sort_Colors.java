// https://leetcode.com/problems/sort-colors/
// Best Approach : Time complexity: O(n)
// Dutch National Flag algorithm

class Solution {
    public void sortColors(int[] nums) {
        // Three pointers:
        // l -> boundary for 0s (left side)
        // m -> current element under consideration
        // h -> boundary for 2s (right side)
        int l = 0;
        int m = 0;
        int h = nums.length - 1;

        // Process elements until middle pointer crosses high pointer
        while (m <= h) {
            if (nums[m] == 0) {
                // If current element is 0, place it at the 'l' position
                // because 0s should be on the left
                swap(nums, m, l);
                l++;
                m++;
            } else if (nums[m] == 1) {
                // If current element is 1, it's already in the middle zone
                m++;
            } else {
                // If current element is 2, place it at the 'h' position
                // because 2s should be on the right
                swap(nums, m, h);
                h--;
                // Don't increment m here because swapped element from end needs to be checked
            }
        }
    }

    // Utility function to swap two elements in the array
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
