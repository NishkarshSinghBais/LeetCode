// https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1

// Time logn and constant space

class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while ( s <= e ){
            int m = s + (e - s)/2;

            if ( arr[m] >= x ){
                ans = m;
                e = m - 1; // If get >=, now look for left half side for smaller one
            } else if ( arr[m] < x ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }
}
