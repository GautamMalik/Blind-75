package DP;

// ques: https://leetcode.com/problems/palindromic-substrings/

public class PallindromicSubstrings {
    public int countSubstrings(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private Boolean[][] dp;

    public int countSubstrings2(String s) {
        int n = s.length();
        dp = new Boolean[n][n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dfs(s, i, j))
                    count++;
            }
        }

        return count;
    }

    private boolean dfs(String s, int i, int j) {
        if (i >= j)
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) != s.charAt(j))
            return dp[i][j] = false;

        return dp[i][j] = dfs(s, i + 1, j - 1);
    }
}
