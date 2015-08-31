import java.util.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            public int compare(final Interval itv1, final Interval itv2) {
                return Integer.signum(itv1.start - itv2.start);
            }
        });

        List<Interval> res = new ArrayList<>();
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                Interval last = res.get(res.size() - 1);
                if (interval.start >= last.start && interval.start <= last.end) {
                    last.end = Math.max(interval.end, last.end);
                } else {
                    res.add(interval);
                }
            }
        }
        return res;
    }
}
