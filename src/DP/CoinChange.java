package DP;

// ques : https://leetcode.com/problems/coin-change/description/

import java.util.Arrays;

public class CoinChange {

    private int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int[] i : dp)
            Arrays.fill(i,-1);
        int ans = tabulation(coins, amount);
        if(ans == (int)1e9)
            return -1;
        return ans;
    }

    private int tabulation(int[] coins, int amount) {
        for(int i=0; i<=amount; i++){
            if(i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int)1e9;
        }

        for(int i=1;i<coins.length; i++){
            for(int j=0; j<=amount; j++){
                int take = (int) 1e9;
                if (j >= coins[i])
                    take = 1+dp[i][j - coins[i]];
                int notTake = dp[i-1][j];
                dp[i][j] = Math.min(take,notTake);
            }
        }
        return dp[coins.length-1][amount];
    }


    private int dfs(int[] coins, int amount, int i) {
        if(i==0){
            if(amount%coins[i] == 0)
                return amount/coins[i];
            else
                return (int) 1e9;
        }

        if(amount==0)
            return 0;

        if(dp[i][amount] != -1)
            return dp[i][amount];

        int take = (int) 1e9;
        if (amount >= coins[i])
            take = 1+dfs(coins, amount - coins[i], i);
        int notTake = dfs(coins, amount, i - 1);

        return dp[i][amount] = Math.min(take, notTake);
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println((coinChange.coinChange(new int[]{1,2},2)));
    }
}
