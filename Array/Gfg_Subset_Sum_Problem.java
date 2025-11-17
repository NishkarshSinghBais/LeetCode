// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int i = 0;
        int n = arr.length;
        int subsetSum = 0;
        return check(i, n, subsetSum, arr, sum);
    }

    public static boolean check(int i, int n, int subsetSum, int[] arr, int sum){

        if ( subsetSum == sum ){
            return true;
        }
        if ( i == n ){
            return false;
        }



        // include arr[i]
        if ( check(i + 1, n, subsetSum + arr[i], arr, sum) ){
            return true;
        }

        // exclude arr[i]
        if ( check(i + 1, n, subsetSum, arr, sum) ){
            return true;
        }

        return false;
    }
}