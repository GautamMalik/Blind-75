package MergeInterval;

// ques: https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((a)->a[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=ans.getLast()[1]){
                ans.getLast()[1] = Math.max(intervals[i][1],ans.getLast()[1]);
            }
            else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        mergeInterval.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},

                {15, 18}
        });
    }
}
