class MyStack {
    private Deque<Integer> queue = new ArrayDeque<>();

    // Push element x onto stack.
    public void push(int x) {
        Deque<Integer> newQueue = new ArrayDeque<>();
        newQueue.offer(x);
        for (Integer item : queue) newQueue.offer(item);
        queue = newQueue;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
