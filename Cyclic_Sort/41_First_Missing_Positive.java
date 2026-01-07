// https://leetcode.com/problems/first-missing-positive/description/

// Time - O(n)

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while ( i < n ){
            int correct = nums[i]-1;
            if ( nums[i] < n && nums[i] > 0 && nums[i] != nums[correct] ){
                swap(i, correct, nums);
            } else {
                i++;
            }
        }

        for (int j=0; j<n; j++){
            if ( nums[j] != j+1 ){
                return j+1;
            }
        }
        return n+1;
    }
    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}