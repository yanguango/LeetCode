public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        boolean neg = Math.signum(dividend) * Math.signum(divisor) < 0;
        long posDividend = Math.abs((long)dividend);
        long posDivisor = Math.abs((long)divisor);
        int res = 0;
        int times = 1;
        long minus = posDivisor;
        while (posDividend >= posDivisor && minus >= posDivisor) {
            if (posDividend >= minus) {
                posDividend -= minus;
                res += times;
                times = times << 1;
                minus = minus << 1;
            } else {
                times = times >> 1;
                minus = minus >> 1;
            }
        }
        return neg ? -res : res;
    }
}
