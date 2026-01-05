// https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

// Time - O(log(min(m, n))

class Solution {
    public int kthElement(int a[], int b[], int k) {
        if (a.length > b.length){
            return kthElement(b, a, k);
        }
        int m = a.length;
        int n = b.length;

        int l = Math.max(0, k-n);
        int h = Math.min(k, m);

        while ( l <= h ){
            int p1 = (l+h)/2;
            int p2 = k-p1;

            int l1 = ( p1 == 0 ) ? Integer.MIN_VALUE : a[p1-1];
            int r1 = ( p1 == m ) ? Integer.MAX_VALUE : a[p1];

            int l2 = ( p2 == 0 ) ? Integer.MIN_VALUE : b[p2-1];
            int r2 = ( p2 == n ) ? Integer.MAX_VALUE : b[p2];

            if ( l1 <= r2 && l2 <= r1 ){
                return Math.max(l1, l2);
            } else if ( l1 > r2 ) {
                h = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        return -1;
    }
}

// Naive Solution - Better Use Priority Queue (Heap)

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