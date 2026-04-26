package ArrayString.Greedy;

// ques: https://leetcode.com/problems/boats-to-save-people/description/

import java.util.Arrays;

public class BoatstoSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0, right=people.length-1;
        int ans=0;
        while(left<=right){
            if(people[right] + people[left] <= limit)
                left++;
            right--;
            ans++;
        }
        return ans;
    }

}
