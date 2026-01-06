// https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1

// Brute Force, Time - O(n^2)

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        for (int i=0; i<arr.length; i++){

            int leftSum = 0;
            for (int j=0; j<i; j++){
                leftSum += arr[j];
            }

            int rightSum = 0;
            for (int j=i+1; j<arr.length; j++){
                rightSum += arr[j];
            }

            if ( leftSum == rightSum ){
                return i;
            }
        }
        return -1;
    }
}

// Better, Time = O(n) and Space = O(n)

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // initialize first index of left and last index of right
        left[0] = arr[0];
        right[n-1] = arr[n-1];

        for (int i=1; i<n; i++){
            left[i] = left[i-1] + arr[i];
        }

        for (int i=n-2; i>=0; i--){
            right[i] = right[i+1] + arr[i];
        }

        for (int i=0; i<n; i++){
            if ( left[i] == right[i] ){
                return i;
            }
        }
        return -1;
    }
}

// Best, Time = O(n) and Space = O(1)

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;

        for (int i=0; i<arr.length; i++){
            totalSum += arr[i];
        }

        int leftSum = 0;

        for (int i=0; i<arr.length; i++){ // Remove - Compare - Add
            totalSum -= arr[i];
            if ( totalSum == leftSum ){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
