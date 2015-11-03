public class Solution {
    // O(n^2) / O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    // O(nlogn) / O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq.get(seq.size() - 1)) {
                seq.add(nums[i]);
            } else {
                int index = Collections.binarySearch(seq, nums[i]);
                if (index < 0) seq.set(-(index + 1), nums[i]);
            }
        }
        return seq.size();
    }
}