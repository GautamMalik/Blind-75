package DP;

//ques: https://leetcode.com/problems/longest-common-subsequence/description/

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonSubsequence {

    private int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return dfs(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    private int dfs(String text1, String text2, int i, int j) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + dfs(text1, text2, i - 1, j - 1);
        else {
            int l = dfs(text1, text2, i - 1, j);
            int r = dfs(text1, text2, i, j - 1);
            return dp[i][j] = Math.max(l,r);
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("adc", "acd"));
    }
}
