// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

// Time - O(n)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
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

        for (int j=0; j<n; j++){
            if ( nums[j] != j+1 ){
                list.add(nums[j]);
            }
        }
        return list;
    }
    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}