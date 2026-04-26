package ArrayString.SlidingWindow;

// ques: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimetoBuyandSellStock {

    public int maxProfitByPrefixSum(int[] prices) {
        int[] leftMin = new int[prices.length];
        leftMin[0]= (int)1e9;
        for(int i=1; i<prices.length; i++){
            leftMin[i] = Math.min(leftMin[i-1],prices[i-1]);
        }

        int ans = 0;
        for(int i=prices.length-1; i>=0; i--){
            ans = Math.max(ans,prices[i]-leftMin[i]);
        }
        return ans;
    }

    public int maxProfitVideoApproach(int[] prices) {

        int buyAt = prices[0];
        int currProfit = 0;
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] < buyAt)
                buyAt = prices[i];
            else{
                currProfit = prices[i] - buyAt;
                if(currProfit > maxProfit)
                    maxProfit = currProfit;
            }
        }
        return maxProfit;
    }

}
