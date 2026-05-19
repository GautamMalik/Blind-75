package MergeInterval;

// ques: https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];

        for (int[] i : intervals) {
            if (i[1] < start)
                left.add(i);
            else if (i[0] > end)
                right.add(i);
            else {
                start = Math.min(i[0], start);
                end = Math.max(i[1], end);
            }
        }

        List<int[]> ans = new ArrayList<>();
        ans.addAll(left);
        ans.add(new int[]{start, end});
        ans.addAll(right);
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        InsertInterval mergeInterval = new InsertInterval();
        mergeInterval.insert(new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        }, new int[]{4, 8});
    }
}
