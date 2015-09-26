public class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        boolean[][] palin = new boolean[s.length()][s.length()];
        dp[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + 1;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || palin[j + 1][i - 1])) {
                    palin[j][i] = true;
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
