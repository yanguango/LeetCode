public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        int count = 0;
        long m = 5;
        while (m <= n) {
            count += (n / m);
            m *= 5;
        }
        return count;
    }
}
