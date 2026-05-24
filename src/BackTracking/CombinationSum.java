package BackTracking;

// ques: https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(),0, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> temp, int idx, int currSum) {
        if(currSum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(idx>= candidates.length || currSum>target)
            return;

        // take
        temp.add(candidates[idx]);
        dfs(candidates, target, temp , idx, currSum + candidates[idx]);
        temp.removeLast();
        dfs(candidates, target, temp, idx+1, currSum);
    }

    /// //////////////////////////////////


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        helper(candidates,target,0, new ArrayList<>());
        return ans;
    }

    private void helper(int[] candidates, int target, int idx,List<Integer> temp) {
        if(idx == candidates.length){
            if(target==0)
                ans.add(new ArrayList<>(temp));
            return;
        }

        if(candidates[idx] <= target) {
            temp.add(candidates[idx]);
            helper(candidates, target - candidates[idx], idx,temp);
            temp.removeLast();
        }
        helper(candidates,target,idx+1,temp);

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,6,7},7);
    }


}
