    public class BestTimeToBuyAndSellStock3 {
        public int maxProfit(int[] prices) {
            if(prices.length < 2) return 0;
            int len = prices.length;
            int[] max_profit_first = new int[len];
            int min = prices[0];
            for(int i = 1; i < len; i++) {
                max_profit_first[i] = Math.max(max_profit_first[i - 1], prices[i] - min);
                min = Math.min(min, prices[i]);
            }
            if(len < 4) return max_profit_first[len - 1];
            int max = prices[len - 1];
            int max_profit_twice = max_profit_first[len - 1];
            for(int i = len - 2; i >= 2; i--) {
                int max_profit_second = Math.max(0, max - prices[i]);
                max_profit_twice = Math.max(max_profit_twice,  max_profit_first[i - 1] + max_profit_second);
                max = Math.max(max, prices[i]);
            }
            return max_profit_twice;
        }
    }