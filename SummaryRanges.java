import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums.length == 0) return res;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) end = nums[i];
            else {
                if (start == end) res.add(String.valueOf(start));
                else res.add(start + "->" + end);
                start = nums[i];
                end = nums[i];
            }
        }

        if (start == end) res.add(String.valueOf(start));
        else res.add(start + "->" + end);
        return res;
    }
}
