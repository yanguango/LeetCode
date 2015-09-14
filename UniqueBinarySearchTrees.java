public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += dp[j] * dp[i - 1 - j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}
