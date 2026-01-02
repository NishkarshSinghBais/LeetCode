// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

// Time = O(n*log(sum)) where sum = total sum [O(log(sum - max))]

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        for (int i=0; i<weights.length; i++){
            if ( weights[i] > max ){
                max = weights[i];
            }
        }
        int sum = 0;
        for (int i=0; i<weights.length; i++){
            sum += weights[i];
        }
        int s = max;
        int e = sum;
        int ans = -1;

        while ( s <= e ){
            int m = s + (e-s)/2;

            if (isValid(m, weights, days)){
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
    boolean isValid(int m, int[] weights, int days){
        int daysNo = 1;
        int weightSum = 0;

        for (int i=0; i<weights.length; i++){
            weightSum += weights[i];
            if ( weightSum > m ){
                daysNo++;
                weightSum = weights[i];
                if ( daysNo > days ){
                    return false;
                }
            }
        }
        return true;
    }
}