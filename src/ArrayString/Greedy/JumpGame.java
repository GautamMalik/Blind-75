package ArrayString.Greedy;

public class JumpGame {
    public boolean canJumpByGreedy(int[] nums) {
        int maxReach = 0;
        for(int i=0; i<nums.length; i++){
            if(i>maxReach)
                return false;
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return maxReach>=nums.length-1;
    }


}
