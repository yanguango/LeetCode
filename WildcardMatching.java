public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            char pc = p.charAt(i - 1);
            for (int j = 0; j <= s.length(); j++) {
                if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || (j > 0 && dp[i][j - 1]);
                } else if (pc == '?') {
                    dp[i][j] = j > 0 && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = j > 0 && s.charAt(j - 1) == pc && dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
