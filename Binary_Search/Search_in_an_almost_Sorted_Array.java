// https://www.geeksforgeeks.org/problems/search-in-an-almost-sorted-array/1

// Time - logn

class Solution {
    public int findTarget(int arr[], int target) {
        int s = 0;
        int e = arr.length - 1;

        while ( s <= e ){
            int m = s + (e-s)/2;

            if ( arr[m] == target ){
                return m;
            }
            if ( m-1 >= 0 && arr[m-1] == target ){
                return m-1;
            }
            if ( m+1 < arr.length && arr[m+1] == target ){
                return m+1;
            }
            if ( arr[m] < target ){
                s = m + 2; // safe (because while (s <= e) if s = n
            } else {
                e = m - 2; // // safe (because while (s <= e) if e = -1
            }
        }
        return -1;
    }
}