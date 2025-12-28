// https://leetcode.com/problems/maximum-score-of-a-split/description/

class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long max = Integer.MIN_VALUE;
        long ps = 0;

        int[] sm = new int[n];
        sm[n-1] = nums[n-1];

        for (int i=n-2; i>=0; i--){
            sm[i] = Math.min(nums[i], sm[i+1]);
        }

        for (int i=0; i<nums.length-1; i++){
            ps += nums[i];
            long score = ps - sm[i+1];
            max = Math.max(max, score);
        }
        return max;
    }
}