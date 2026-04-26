package ArrayString.ManipulationAndHashing;

// ques: https://leetcode.com/problems/contains-duplicate/description/

import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicateWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        return set.size()<nums.length;
    }

    public boolean containsDuplicateWithMap(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) != null)
                return true;
            map.put(nums[i],i);
        }
        return false;
    }
}
