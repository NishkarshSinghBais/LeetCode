// https://leetcode.com/problems/minimum-subarray-length-with-distinct-sum-at-least-k/

// Time - O(n) and Space = O(n)

class Solution {
    public int minLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        while ( j<nums.length ){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            // only add if frequency of element is 1 in the map
            // because duplicates allowed but sum of duplicates not...you'll get soon hehehe
            if ( map.get(nums[j]) == 1){
                sum += nums[j];
            }

            while ( sum >= k ){
                minLen = Math.min(minLen, j-i+1);
                map.put(nums[i], map.get(nums[i]) - 1);
                // only subtract when frequency of element become 0 in the map
                if ( map.get(nums[i]) == 0 ){
                    sum -= nums[i];
                }
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}