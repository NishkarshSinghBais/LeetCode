// https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ans = k;
        for (int i=0; i<arr.length; i++){
            if ( arr[i] > ans ){
                return ans;
            } else {
                ans++;
            }
        }
        return ans;
    }
}