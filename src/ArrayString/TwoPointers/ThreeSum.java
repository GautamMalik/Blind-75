package ArrayString.TwoPointers;
import java.util.*;

// ques : https://leetcode.com/problems/3sum/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        Set<List<Integer>> ans = new HashSet<>();
        while(left<nums.length-2){
            if(left>0 && nums[left]==nums[left-1]) {
                left++;
                continue;
            }
            List<List<Integer>> temp = twoSum(nums,left+1,-nums[left]);
            for(List<Integer> i : temp){
                i.add(nums[left]);
                ans.add(i);
            }
            left++;
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> twoSum(int[] nums,int left ,int target){
        int  right=nums.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        while(left<right){
            int temp = nums[left] + nums[right];
            if(temp==target) {
                ans.add(new ArrayList<>(List.of(nums[left], nums[right])));
                left++;
                right--;
            }
            else if(temp<target) left++;
            else right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
    }
}
