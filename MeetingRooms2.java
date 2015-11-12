/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Integer> times = new ArrayList<>();
        for (Interval itv : intervals) {
            times.add(itv.start);
            times.add(-itv.end);
        }

        Collections.sort(times, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) != Math.abs(b))
                    return Integer.compare(Math.abs(a), Math.abs(b));
                else
                    return Integer.compare(a, b);
            }
        });

        int rooms = 0;
        int minRooms = 0;
        for (int t : times) {
            if (t >= 0) {
                rooms++;
                minRooms = Math.max(minRooms, rooms);
            } else {
                rooms--;
            }
        }
        return minRooms;
    }
}