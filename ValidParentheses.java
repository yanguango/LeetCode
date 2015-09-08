public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.peek() == null || !match(stack.peek(), c)) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean match(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
               (c1 == '{' && c2 == '}') ||
               (c1 == '[' && c2 == ']');
    }
}
