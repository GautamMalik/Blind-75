package DP;

// ques: https://leetcode.com/problems/climbing-stairs/

import java.util.Arrays;

public class ClimbingStairs {
    private int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return tabulation(n);
    }

    private int tabulation(int n) {
        dp[0] = 1; dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private int dfs(int n) {
        if(n<2)
            return 1;

        if(dp[n]!=-1)
            return dp[n];

        return dp[n] = dfs(n-1) + dfs(n-2);
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        climbingStairs.climbStairs(2);
    }
}
