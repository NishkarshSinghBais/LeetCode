// https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

// Brute Force, Time - O(n^2) and Space = O(1) output array doesn't count

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if ( i != j ){
                    res[i] *= arr[j];
                }
            }
        }
        return res;
    }
}