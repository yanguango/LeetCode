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

// Without using stack with Morris travesal
public class BSTIterator1 {
    private TreeNode current;
    private TreeNode prev;

    public BSTIterator1(TreeNode root) {
        this.current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            if (current.left == null) {
                TreeNode res = current;
                current = current.right;
                return res.val;
            } else {
                prev = current.left;
                while (prev.right != null && prev.right != current)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    prev.right = null;
                    TreeNode res = current;
                    current = current.right;
                    return res.val;
                }
            }
        }
        return 0;
    }
}
