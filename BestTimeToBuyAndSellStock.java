public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            profit = Integer.max(profit, prices[i] - min);
            min = Integer.min(min, prices[i]);
        }
        return profit;
    }
}