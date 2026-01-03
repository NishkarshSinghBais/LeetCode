// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int[] mix = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int l =  0;

        while ( i < a.length && j < b.length ){
            if ( a[i] < b[j] ){
                mix[l] = a[i];
                i++;
                l++;
            } else {
                mix[l] = b[j];
                j++;
                l++;
            }
        }
        while ( i < a.length ){
            mix[l] = a[i];
            i++;
            l++;
        }
        while ( j < b.length ){
            mix[l] = b[j];
            j++;
            l++;
        }
        return mix[k-1];
    }
}