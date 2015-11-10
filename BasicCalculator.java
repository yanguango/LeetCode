public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Integer> signs = new ArrayDeque<>();
        int sign = 1;
        int n = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + (c - '0');
            } else if (c != ' ') {
                result += sign * n;
                n = 0;
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                } else if (c == '(') {
                    nums.push(result);
                    signs.push(sign);
                    sign = 1;
                    result = 0;
                } else if (c == ')' && !signs.isEmpty()) {
                    result = result * signs.pop() + nums.pop();
                }
            }
        }
        result += sign * n;
        return result;
    }
}