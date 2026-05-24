package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums,int target, int idx, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx; i<nums.length; i++){
            if(i>idx && nums[i]==nums[i-1])
                continue;
            if(nums[i]>target)
                break;
            temp.add(nums[i]);
            dfs(nums,target-nums[i], i+1, temp);
            temp.removeLast();
        }
    }
}
