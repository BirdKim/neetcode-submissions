class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int buy = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            maxProf = Math.max(maxProf, prices[sell] - buy);
            buy = Math.min(buy, prices[sell]);
        }
        return maxProf;
    }
}
