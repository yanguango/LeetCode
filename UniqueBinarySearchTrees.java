public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // If you choose i as root, all numbers less than i will be at left suntree
        // all numbers greater than i will be at right subtree
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
