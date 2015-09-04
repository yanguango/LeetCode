public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = k;
        int different = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int temp = same;
            same = different;
            different = temp * (k - 1) + different * (k - 1);
        }
        return same + different;
    }
}
