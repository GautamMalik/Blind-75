package BackTracking;

import java.util.ArrayList;
import java.util.List;

// ques: https://leetcode.com/problems/subsets/

public class Subsets {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int idx, List<Integer> temp){
        if(idx==nums.length)
            ans.add(new ArrayList<>(temp));
        if(idx>=nums.length)
            return;

        temp.add(nums[idx]);
        dfs(nums, idx+1, temp);
        temp.removeLast();
        dfs(nums, idx+1, temp);
    }
}
