// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

// Time - logn

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 1;
        int e = arr.length - 2;
        int n = arr.length;

        if ( arr.length == 1 ){
            return 0;
        }
        if ( arr[0] > arr[1] ){
            return 0;
        }
        if ( arr[n-1] > arr[n-2] ){
            return n-1;
        }

        while ( s <= e ){
            int m = s + (e-s)/2;

            if ( arr[m] > arr[m-1] && arr[m] > arr[m+1] ){
                return m;
            }
            if ( arr[m] > arr[m-1] ){ // increasing curve, eliminate, go high for peak

                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}