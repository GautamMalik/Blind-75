package MergeInterval;

// ques: https://www.lintcode.com/problem/920/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        boolean ans = true;

        if (intervals == null || intervals.size() <= 1)
            return ans;

        intervals.sort(Comparator.comparingInt(a -> a.start));
        int end = intervals.get(0).end;

        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start < end){
                ans = false;
                break;
            }
            end = intervals.get(i).end;
        }
        return ans;
    }

    public static void main(String[] args) {
        MeetingRooms m = new MeetingRooms();
        m.canAttendMeetings(new ArrayList<>(List.of(
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20)
        )));
    }
}
