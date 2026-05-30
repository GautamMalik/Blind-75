package DP;

// ques: https://leetcode.com/problems/house-robber-ii/description/

import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber2 {
    private int[] dp;
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        dp = new int[nums.length];
        return Math.max(tabulation(Arrays.copyOfRange(nums,0,nums.length-1)),tabulation(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int tabulation(int[] nums) {
        if(nums.length==0)
            return 0;
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            int rob = 0;
            if(i==1)
                rob = nums[i];
            else
                rob = dp[i-2] + nums[i];
            int notRob = dp[i-1];
            dp[i] = Math.max(rob,notRob);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        houseRobber2.rob(new int[]{1,2});
    }

}
