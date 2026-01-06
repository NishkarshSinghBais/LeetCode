// https://leetcode.com/problems/two-sum/description/

// Time - O(n) and Space = O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int more = target - nums[i];

            if ( map.containsKey(more) ){
                int first = i;
                int second = map.get(more);
                return new int[]{first, second};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}