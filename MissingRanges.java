public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(lower == upper ? lower + "" : lower + "->" + upper);
            return res;
        }
        int current = 0;
        while (lower <= upper) {
            if (current == nums.length) {
                res.add(lower == upper ? lower + "" : lower + "->" + upper);
                return res;
            }
            int num = nums[current] > upper ? upper : nums[current];
            if (num == lower) {
                lower++;
            } else if (num == lower + 1) {
                res.add(lower + "");
                lower = num + 1;
            } else if (num > lower) {
                res.add(lower + "->" + (num - 1));
                lower = num + 1;
            }
            current++;
        }

        return res;
    }
}
