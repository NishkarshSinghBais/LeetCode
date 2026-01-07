// https://leetcode.com/problems/find-the-duplicate-number/description/

// Time - O(n)

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;

        while ( i < n ){
            int correct = nums[i] - 1;
            if ( nums[i] >= 1 && nums[i] != nums[correct] ){
                swap(i, correct, nums);
            } else {
                i++;
            }
        }
        for (int j=0; j<nums.length; j++){
            if ( nums[j] != j+1 ){
                return nums[j];
            }
        }
        return -1;
    }
    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}