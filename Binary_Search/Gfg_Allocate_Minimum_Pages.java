// https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// Time = O(N*logS) where S = Sum of all pages (or sum - max )

class Solution {
    public int findPages(int[] arr, int k) {

        if ( arr.length < k ){
            return -1;
        }

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
        int stud = 1;

        for (int i=0; i<arr.length; i++){
            sum += arr[i];
            if ( sum > ans ){
                stud++;
                sum = arr[i];
                if ( stud > k ){
                    return false;
                }
            }
        }
        return true;
    }
}