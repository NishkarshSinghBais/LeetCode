// https://leetcode.com/problems/missing-number/description/

// Time - O(n)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while ( i < n ){
            int correct = nums[i];
            if ( correct < n && nums[i] != nums[correct] ){
                swap(i, correct, nums);
            } else {
                i++;
            }
        }

        for (int j=0; j<n; j++){
            if ( nums[j] != j ){
                return j;
            }
        }
        return n;
    }
    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}