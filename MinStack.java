class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> mins = new ArrayDeque<>();
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || x <= getMin()) mins.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int n = stack.pop();
        if (getMin() == n) mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
