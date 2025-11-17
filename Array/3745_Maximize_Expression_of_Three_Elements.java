// https://leetcode.com/problems/maximize-expression-of-three-elements/description/

class Solution {
    public int maximizeExpressionOfThree(int[] nums) {

        // 'a' = largest number
        // 'b' = second largest number
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        // 'c' = smallest number
        int c = Integer.MAX_VALUE;

        // Traverse all numbers once (O(n))
        for (int x : nums) {

            // Update largest and second largest
            if (x > a) {
                // If x becomes new largest, previous 'a' becomes second largest
                b = a;
                a = x;
            }
            // If x is not largest but greater than current second largest
            else if (x > b) {
                b = x;
            }

            // Update smallest number
            if (x < c) {
                c = x;
            }
        }

        // The expression is: (largest + second largest - smallest)
        return a + b - c;
    }
}
