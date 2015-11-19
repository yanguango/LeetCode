public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lower) {
                continue;
            } else if (nums[i] == lower) {
                lower++;
            } else {
                if (nums[i] <= upper) {
                    if (nums[i] == lower + 1) res.add("" + lower);
                    else res.add(lower + "->" + (nums[i] - 1));
                    lower = nums[i] + 1;
                }
            }
        }

        if (upper == lower) {
            res.add("" + lower);
        } else if (upper > lower) {
            res.add(lower + "->" + upper);
        }
        return res;
    }
}