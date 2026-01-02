// https://leetcode.com/problems/split-array-largest-sum/description/

// Time - O(n*log(sum))

class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        for (int i=0; i<nums.length; i++){
            if ( nums[i] > max ){
                max = nums[i];
            }
        }
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        int s = max;
        int e = sum;
        int ans = -1;

        while ( s <= e ){
            int m = s + (e-s)/2;

            if (isValid(m, nums, k)){
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
    boolean isValid(int m, int[] nums, int k){
        int split = 1;
        int sum = 0;

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if ( sum > m ){
                split++;
                sum = nums[i];
                if ( split > k ){
                    return false;
                }
            }
        }
        return true;
    }
}