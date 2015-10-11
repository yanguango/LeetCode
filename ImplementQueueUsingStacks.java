class MyQueue {
    // Push element x to the back of queue.
    private Deque<Integer> stackIn = new ArrayDeque<>();
    private Deque<Integer> stackOut = new ArrayDeque<>();

    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        moveInToOut();
        stackOut.pop();
    }

    // Get the front element.
    public int peek() {
        moveInToOut();
        return stackOut.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        moveInToOut();
        return stackOut.isEmpty();
    }

    private void moveInToOut() {
        if(stackOut.isEmpty()) {
            while(!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}