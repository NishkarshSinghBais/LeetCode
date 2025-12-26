// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int i = 0;
        int subsetSum = 0;
        return check(i, subsetSum, arr, sum);
    }

    public static boolean check(int i, int subsetSum, int[] arr, int sum){

        if ( i == arr.length ){
            return subsetSum == sum; // checks is subsetSum == sum, return true/false
        }
        if ( subsetSum > sum ){
            return false;
        }

        // include arr[i]
        if ( check(i + 1, subsetSum + arr[i], arr, sum) ){
            return true;
        }

        // exclude arr[i]
        if ( check(i + 1, subsetSum, arr, sum) ){
            return true;
        }

        return false;
    }
}