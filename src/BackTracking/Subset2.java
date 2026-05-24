package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int idx, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            dfs(nums,i+1,temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Subset2 subset2 = new Subset2();
        subset2.subsetsWithDup(new int[]{1,2,2});
    }
}
