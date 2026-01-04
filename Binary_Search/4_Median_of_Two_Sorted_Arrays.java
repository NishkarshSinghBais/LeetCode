// https://leetcode.com/problems/median-of-two-sorted-arrays/

// Time = O(log(min(m))

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1.length > nums2.length ){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int h = m;

        while ( l <= h ){
            int p1 = (l+h)/2;
            int p2 = (m+n+1)/2 - p1;

            int l1 = ( p1 == 0 ) ? Integer.MIN_VALUE : nums1[p1-1];
            int r1 = ( p1 == m ) ? Integer.MAX_VALUE : nums1[p1];

            int l2 = ( p2 == 0 ) ? Integer.MIN_VALUE : nums2[p2-1];
            int r2 = ( p2 == n ) ? Integer.MAX_VALUE : nums2[p2];

            if ( l1 <= r2 && l2 <= r1 ){
                if ( (n+m)%2 == 0 ){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                } else {
                    return (Math.max(l1, l2));
                }
            } else if ( l1 > r2 ){
                h = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        return 0.0;
    }
}

// Brute Force Solution


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