public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                int n2 = Integer.valueOf(stack.pop());
                int n1 = Integer.valueOf(stack.pop());
                stack.push("" + calculate(n1, n2, s));
            } else {
                stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public int calculate(int n1, int n2, String s) {
        if (s.equals("+")) return n1 + n2;
        else if (s.equals("-")) return n1 - n2;
        else if (s.equals("*")) return n1 * n2;
        else if (s.equals("/")) return n1 / n2;
        else return 0;
    }
}