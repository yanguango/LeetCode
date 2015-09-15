public class VerifyPreorderSequenceInBinarySearchTree {
    // Using stack to store the roots when iteration
    // and find the direct parent if the number is greater than the peek of stack
    public boolean verifyPreorder(int[] preorder) {
        long root = (long)Integer.MIN_VALUE - 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : preorder) {
            if (i < root) return false;
            while (!stack.isEmpty() && i > stack.peek()) {
                root = (long)stack.pop();
            }
            stack.push(i);
        }
        return true;
    }

    // Using the preorder array as stack
    public boolean verifyPreorder1(int[] preorder) {
        long root = (long)Integer.MIN_VALUE - 1;
        int stack = -1;
        for (int i : preorder) {
            if (i < root) return false;
            while (stack >= 0 && i > preorder[stack]) {
                root = (long)preorder[stack--];
            }
            preorder[++stack] = i;
        }
        return true;
    }
}
