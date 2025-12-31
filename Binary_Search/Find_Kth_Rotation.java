// https://www.geeksforgeeks.org/problems/rotation4723/1

// Time - logn

// IDEA - index of smallest element int the array gives
// the number of times array is rotated, find it and return

class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int s = 0;
        int e = arr.length - 1;
        if ( arr[s] <= arr[e] ){
            return 0;
        }
        int n = arr.length;

        while ( s <= e ){
            int m = s + (e-s)/2;
            int l = (m+n-1)%n; // previous index of m; wraps to last index if m is 0
            int r = (m+1)%n; // next index of m; wraps to first index if m is last

            // check if middle element is minimum, if so, return it
            if ( arr[m] <= arr[l] && arr[m] <= arr[r]){
                return m;
            }
            if ( arr[m] <= arr[e] ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return 0;
    }
}