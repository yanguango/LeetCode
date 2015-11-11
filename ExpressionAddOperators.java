public class Solution {
    public List<String> addOperators(String num, int target) {
        Deque<Long> stack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        dfs(num, 0, stack, '+', res, "", target);
        return res;
    }

    public void dfs(String num, int index, Deque<Long> valStack,
                    char lastOp, List<String> res, String exp, int target) {
        if (index >= num.length()) return;
        for (int end = index + 1; end <= num.length(); end++) {
            if (num.charAt(index) == '0' && end - index > 1) break;
            long d = Long.valueOf(num.substring(index, end));
            Deque<Long> newValStack = new ArrayDeque<>(valStack);
            if (lastOp == '*') {
                newValStack.push(newValStack.pop() * d);
            } else if (lastOp == '+') {
                newValStack.push(d);
            } else if (lastOp == '-') {
                newValStack.push(-d);
            }

            if (end == num.length()) {
                long ans = 0;
                for (long n : newValStack) {
                    ans += n;
                }
                if (ans == target) res.add(exp + d);
                return;
            }

            String ops = "+-*";
            for (int i = 0; i < ops.length(); i++) {
                char op = ops.charAt(i);
                dfs(num, end, newValStack, op, res, exp + d + op, target);
            }
        }

    }
}