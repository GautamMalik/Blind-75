package ArrayString.ManipulationAndHashing;

// ques: https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length==0)
            return 0;

        Map<Integer,Boolean> map = new HashMap<>();

        for(int i : nums)
            map.put(i,false);

        int ans = 1;

        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]))
                continue;

            map.put(nums[i],true);
            int tempAns=1;
            int tempVal = nums[i];
            while(true){
                if(map.get(--tempVal) != null){
                    tempAns++;
                    map.put(tempVal,true);
                } else
                    break;
            }
            tempVal = nums[i];
            while(true){
                if(map.get(++tempVal) != null){
                    tempAns++;
                    map.put(tempVal,true);
                } else
                    break;
            }
            ans = Math.max(ans,tempAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
