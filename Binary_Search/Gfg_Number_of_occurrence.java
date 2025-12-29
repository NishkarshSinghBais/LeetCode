// https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

// Time logn and space O(1)

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int first = find(arr, target, true);
        int last = find(arr, target, false);

        if ( first == -1 || last == -1 ){
            return 0;
        }

        return (last - first + 1);
    }
    int find(int[] arr, int target, boolean findFirst){
        int ans = -1;
        int s = 0;
        int e = arr.length - 1;

        while ( s <= e ){
            int m = s + (e - s)/2;

            if ( target == arr[m] ){
                ans = m;
                if ( (findFirst) ){
                    e = m -1;
                } else {
                    s = m + 1;
                }
            } else if ( target > arr[m] ){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }
}