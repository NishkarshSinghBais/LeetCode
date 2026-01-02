// https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1

// Time - O(n*log(sum))

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int max = 0;
        for (int i=0; i<arr.length; i++){
            if ( arr[i] > max ){
                max = arr[i];
            }
        }
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        int s = max;
        int e = sum;
        int ans = -1;

        while ( s <= e ){
            int m = s + (e-s)/2;

            if ( isValid(m, arr, k) ){
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }

    boolean isValid(int ans, int[] arr, int k){
        int sum = 0;
        int painter = 1;

        for (int i=0; i<arr.length; i++){
            sum += arr[i];
            if ( sum > ans ){
                painter++;
                sum = arr[i];
                if ( painter > k ){
                    return false;
                }
            }
        }
        return true;
    }
}