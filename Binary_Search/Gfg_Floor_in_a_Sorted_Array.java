// https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

// Time logn and constant space

class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + (e - s)/2;

            if ( arr[m] <= x ){
                ans = m;
                s = m + 1; // If get <=, now look for right half side for larger one
            } else if ( arr[m] > x ){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}
