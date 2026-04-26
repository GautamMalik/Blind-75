package ArrayString.Greedy;

// ques: https://leetcode.com/problems/maximum-subarray/description/

public class MaximumSubarray {
    public int maxSubArrayBySlidingWindowOrKadaneAlgo(int[] nums) {
        int ans = (int)-1e9, sum = 0;
        for(int i : nums){
            sum = sum + i;
            ans = Math.max(ans,sum);
            if(sum<0)  sum = 0;
        }
        return ans;
    }

    public int maxSubArrayByGreedy(int[] nums) {
        int sum= nums[0], ans = nums[0];
        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i],sum + nums[i]);
            ans = Math.max(ans,sum);
        }
        return ans;
    }

}
