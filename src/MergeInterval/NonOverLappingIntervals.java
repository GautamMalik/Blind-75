package MergeInterval;

// ques: https://leetcode.com/problems/non-overlapping-intervals/description/

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[1]));
        int prevEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < prevEnd) {
                ans++;
            }
            else
                prevEnd = intervals[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        NonOverLappingIntervals nonOverLappingIntervals = new NonOverLappingIntervals();
        nonOverLappingIntervals.eraseOverlapIntervals(new int[][]{
                {1, 10},
                {2, 7},
                {3, 19},
                {8, 12},
                {10,20}
        });
    }
}
