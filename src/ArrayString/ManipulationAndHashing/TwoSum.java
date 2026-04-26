package ArrayString.ManipulationAndHashing;

// ques: https://leetcode.com/problems/two-sum/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer temp = map.get(target-nums[i]);
            if(temp!=null){
                return new int[]{temp,i};
            } else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }


    public boolean twoSumIfOutputIsBoolean(int[] nums, int target) {
        int left=0, right=nums.length-1;
        Arrays.sort(nums);
        while(left<right){
            int sum=nums[left] + nums[right];
            if(sum==target){
                return true;
            } else if(sum<target)
                left++;
            else
                right--;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] response = twoSum.twoSum(new int[]{1, 3, 5, 17, 19, 12, 23}, 12);
        System.out.println("Response of twoSumIfOutputIsBoolean : [" + response[0] + "," + response[1] + "]");


        boolean res = twoSum.twoSumIfOutputIsBoolean(new int[]{1, 3, 5, 7, 9, 12, 23}, 12);
        System.out.println("Response of twoSumIfOutputIsBoolean : " + res);
    }
}
