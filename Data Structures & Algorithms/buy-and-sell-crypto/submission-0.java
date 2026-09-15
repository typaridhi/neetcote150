class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int profit = 0;
        for (int i = 1 ; i < prices.length ; i++)
        {
            minprice = Math.min(minprice , prices [i]);
            int currProfit= prices[i]-minprice;
            profit = Math.max(currProfit , profit);
            if(profit < 0)
              return 0;
                    }
                    return profit;
    }
}
