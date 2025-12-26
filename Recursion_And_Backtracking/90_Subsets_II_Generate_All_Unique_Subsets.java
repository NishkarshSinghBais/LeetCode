// https://leetcode.com/problems/subsets-ii/description/

// Time 2^n

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int idx = 0;
        subsets(idx, nums, list, ans);
        return ans;
    }
    void subsets(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans){
        // First of all save the empty list
        // then for every recursion level and recursion call we will get a subset... save it
        ans.add(new ArrayList<>(list));
        for (int i=idx; i<nums.length; i++){
            // for skipping duplicates at same level
            if ( i > idx && nums[i] == nums[i - 1] ){
                continue;
            }
            list.add(nums[i]);
            subsets(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}