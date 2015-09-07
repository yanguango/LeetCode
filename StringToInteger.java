public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }
        long num = 0;
        for (int i = start; i < str.length(); i++) {
            int d = str.charAt(i) - '0';
            if (d >= 0 && d <= 9) {
                num = num * 10 + d;
            } else {
                break;
            }
            if (sign > 0 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign < 0 && num - Integer.MAX_VALUE > 1) return Integer.MIN_VALUE;
        }
        return (int)(sign * num);
    }
}
