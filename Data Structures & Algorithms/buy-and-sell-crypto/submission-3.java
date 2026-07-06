class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            maxProf = Math.max(maxProf, prices[i]-buy);
            buy = Math.min(buy, prices[i]);
        }
        return maxProf;
    }
}
