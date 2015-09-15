/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode current;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.current = root;
        this.stack = new ArrayDeque<TreeNode>();
        while (current != null && current.left != null) {
            stack.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = current.val;
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                stack.push(current);
                current = current.left;
            }
        } else {
            current = stack.isEmpty() ? null : stack.pop();
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
