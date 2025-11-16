class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        // 'a' will store the largest number found so far
        int a = Integer.MIN_VALUE;

        // 'b' will store the second largest number found so far
        int b = Integer.MIN_VALUE;

        // 'c' will store the smallest number found so far
        int c = Integer.MAX_VALUE;

        // Enhanced for loop: iterates over each element 'x' in the array 'nums'
        for (int x : nums) {
            // If current number 'x' is greater than the largest so far,
            // update 'b' to the old largest and 'a' to the new largest
            if (x > a) {
                b = a;
                a = x;
            }
            // If 'x' is not greater than 'a' but greater than 'b',
            // update 'b' to 'x'
            else if (x > b) {
                b = x;
            }

            // Update 'c' if 'x' is smaller than the smallest so far
            if (x < c) {
                c = x;
            }
        }

        // Return the expression a + b - c, which uses
        // the two largest numbers minus the smallest number
        return a + b - c;
    }
}
