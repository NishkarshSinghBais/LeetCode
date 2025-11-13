Brute Force : Time O(n)

class Solution {
    public int maxProfit(int[] prices) {
        // Initialize buy as the maximum possible value
        // (so the first price will always replace it)
        int buy = Integer.MAX_VALUE;

        // This variable will store the maximum profit found so far
        int profit = 0;

        // Loop through each day's price
        for (int i = 0; i < prices.length; i++) {

            // If today's price is lower than our current buy price,
            // update buy to this new lower price (best day to buy so far)
            if (prices[i] < buy) {
                buy = prices[i];
            }

            // Check if selling today gives a better profit
            // than any profit seen before
            if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }

        // Return the maximum profit found
        // (0 if no profitable transaction is possible)
        return profit;
    }
}
