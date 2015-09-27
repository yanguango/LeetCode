public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                String word = s.substring(j - 1, i);
                dp[i] = dp[i] || (dp[j - 1] && wordDict.contains(word));
            }
        }
        return dp[dp.length - 1];
    }
}
