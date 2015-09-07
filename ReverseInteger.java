public class ReverseInteger {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        long res = 0;
        x = x * sign;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE) return 0;
        return (int)res * sign;
    }
}
