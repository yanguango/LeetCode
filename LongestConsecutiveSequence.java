public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int max = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int val = n;
                while (set.remove(val++));
                max = Math.max(max, val - n - 1);
            }
        }
        return max;
    }
}