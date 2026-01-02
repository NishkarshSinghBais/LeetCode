// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mix = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k =  0;

        while ( i < nums1.length && j < nums2.length ){
            if ( nums1[i] < nums2[j] ){
                mix[k] = nums1[i];
                i++;
                k++;
            } else {
                mix[k] = nums2[j];
                j++;
                k++;
            }
        }
        while ( i < nums1.length ){
            mix[k] = nums1[i];
            i++;
            k++;
        }
        while ( j < nums2.length ){
            mix[k] = nums2[j];
            j++;
            k++;
        }

        int n = mix.length;

        if ( n % 2 == 1 ){
            return mix[n/2];
        } else {
            return (mix[(mix.length/2)] + mix[(mix.length/2) - 1])/2.0;
        }
    }
}