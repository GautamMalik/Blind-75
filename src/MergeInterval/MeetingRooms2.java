package MergeInterval;

// ques: https://www.lintcode.com/problem/919/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Max overlapping intervals same ques

public class MeetingRooms2 {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] startTime = new int[intervals.size()];         // seperate sorted start times
        int[] endTime = new int[intervals.size()];           // seperate sorted end times

        for (int i = 0; i < intervals.size(); i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int ans = 0, count=0;
        int startIdx=0 , endIdx =0;

        while(startIdx<startTime.length){
            if(startTime[startIdx] < endTime[endIdx]){
                count++;
                startIdx++;
            }else{
                count--;
                endIdx++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    public static void main(String[] args) {
        MeetingRooms2 m = new MeetingRooms2();
        int ans = m.minMeetingRooms(new ArrayList<>(List.of(
                new Interval(1, 10),
                new Interval(2, 7),
                new Interval(3, 19),
                new Interval(8, 12),
                new Interval(10, 20)
        )));
        System.out.println(ans);
    }
}
