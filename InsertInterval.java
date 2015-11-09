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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        for (Interval interval : intervals) {
            if (newInterval == null) {
                res.add(interval);
                continue;
            }
            if (newInterval.end < interval.start) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
                res.add(new Interval(Math.min(newInterval.start, interval.start), interval.end));
                newInterval = null;
            } else if (newInterval.start >= interval.start && newInterval.start <= interval.end) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            } else if (newInterval.start > interval.end) {
                res.add(interval);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }
}