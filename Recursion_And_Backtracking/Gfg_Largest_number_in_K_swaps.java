// https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

// Time Permutation So - O(n!), Space O(n) recursion Depth (maximum simultaneous call = n)



class Solution {
    String maxStr; // Global Variable For Storing Answer
    public String findMaximumNum(String s, int k) {
        maxStr = s; // Initially Original
        char[] arr = s.toCharArray();
        int idx = 0;
        find(idx, arr, k);
        return maxStr;
    }

    public void find(int idx, char[] arr, int k){
        if ( k == 0 || idx == arr.length ){
            return;
        }

        char max = arr[idx];
        for (int i=idx+1; i<arr.length; i++){
            if ( arr[i] > max ){
                max = arr[i];
            }
        }

        // if current digit is not max, we'll use one swap
        if ( max != arr[idx] ){
            k--;
        }

        for (int i=idx; i<arr.length; i++){
            if ( arr[i] == max ){
                swap(arr, i, idx);

                // Update if current string is greater
                String curr = new String(arr);
                if ( curr.compareTo(maxStr) > 0 ){
                    maxStr = curr;
                }

                find(idx+1, arr, k);

                // Backtrack
                swap(arr, i, idx);
            }
        }
    }

    public void swap(char[] arr, int i, int idx){
        char temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}