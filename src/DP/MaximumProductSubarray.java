package DP;

// ques: https://leetcode.com/problems/maximum-product-subarray/

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int leftProd = 1, rightProd = 1;

        int ans= Integer.MIN_VALUE;

        for(int i=0; i< nums.length; i++){
            if(leftProd == 0)
                leftProd = 1;
            if(rightProd == 0)
                rightProd = 1;

            leftProd *= nums[i];
            rightProd *= nums[nums.length-1-i];

            ans = Math.max(ans, Math.max(leftProd,rightProd));
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,0,-1,-2}));
    }
}
