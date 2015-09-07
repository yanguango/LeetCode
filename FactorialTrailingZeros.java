public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int count = 0;
        // m maybe exceeds Integer.MAX_VALUE
        // use long to hold m
        long m = 5;
        while (m <= n) {
            count += (n / m);
            m *= 5;
        }
        return count;
    }
}
