public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("+-*/".indexOf(ch) >= 0) {
                sign = ch;
            } else if (ch != ' ') {
                n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if (sign == '+') stack.push(n);
                else if (sign == '-') stack.push(-n);
                else if (sign == '*') stack.push(stack.pop() * n);
                else if (sign == '/') stack.push(stack.pop() / n);
            }
        }
        int res = 0;
        for (int i : stack) res += i;
        return res;
    }
}