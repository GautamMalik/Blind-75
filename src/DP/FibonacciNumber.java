package DP;

// ques: https://leetcode.com/problems/fibonacci-number/description/

import java.util.Arrays;

public class FibonacciNumber {

    private int[] dp;

    public int fib(int n) {
       dp = new int[n+1];
       Arrays.fill(dp,-1);
       return findFibTabulation(n);
    }

    private int findFib(int n) {
        if(n<2)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = findFib(n-1) + findFib(n-2);
    }

    private int findFibTabulation(int n) {
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<=n ; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        fibonacciNumber.fib(10);
    }
}
