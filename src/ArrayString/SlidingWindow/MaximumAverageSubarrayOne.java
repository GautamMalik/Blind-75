package ArrayString.SlidingWindow;

// ques: https://leetcode.com/problems/maximum-average-subarray-i/description/

public class MaximumAverageSubarrayOne {
    public double findMaxAverage(int[] nums, int k) {
        int left=0, right= k-1;
        double sum=0;
        for(int i=0; i<right; i++){  // sum for upto k-1 element
            sum += nums[i];
        }
        double ans = -1e9;

        while(right<nums.length){
            sum += nums[right];
            ans = Math.max(ans,sum/k);
            sum -= nums[left];
            right++;
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayOne maximumAverageSubarrayOne = new MaximumAverageSubarrayOne();
        maximumAverageSubarrayOne.findMaxAverage(new int[]{1,12,-5,-6,50,3},4);
    }

}
