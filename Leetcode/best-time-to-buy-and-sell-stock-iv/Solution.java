class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] profits = new int[k + 1][len];
        for(int i = 1; i < k + 1; i++) {
            int maxP = Integer.MIN_VALUE;
            for(int j = 1; j < len; j++) {
                maxP = Math.max(maxP, profits[i - 1][j - 1] - prices[j - 1]);
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] + maxP);
            }
        }
        return profits[k][len - 1];
    }
}
