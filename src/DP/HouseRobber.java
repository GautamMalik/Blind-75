package DP;

// ques: https://leetcode.com/problems/house-robber/

import java.util.Arrays;

public class HouseRobber {
    private int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return tabulation(nums);
    }

    private int tabulation(int[] nums) {
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            int rob=0;
            if(i==1)
                rob = nums[i];
            else
                rob = nums[i] + dp[i-2];
            int notRob = dp[i-1];
            dp[i] = Math.max(rob,notRob);
        }
        return dp[nums.length-1];
    }

    private int dfs(int idx, int[] nums) {
        if(idx == 0)
            return nums[0];
        if(idx < 0)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int rob = nums[idx] + dfs(idx-2,nums);
        int notRob = dfs(idx-1,nums);
        return dp[idx] = Math.max(rob,notRob);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(new int[]{1,2});
    }
}
