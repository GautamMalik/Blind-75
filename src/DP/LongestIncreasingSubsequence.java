package DP;

import java.util.Arrays;

// ques: https://leetcode.com/problems/longest-increasing-subsequence/

public class LongestIncreasingSubsequence {
    private int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return dfs(0, -1,nums);
    }

    private int dfs(int idx, int prevIdx ,int[] nums) {
        if(idx>=nums.length)
            return 0;

        if(dp[idx][prevIdx+1] != -1)
            return dp[idx][prevIdx+1];

        int pick=0;
        if(prevIdx == -1 ||nums[idx] > nums[prevIdx])
            pick = 1 + dfs(idx+1, idx, nums);
        int notPick = dfs(idx+1, prevIdx, nums);

        return dp[idx][prevIdx+1] = Math.max(pick,notPick);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
