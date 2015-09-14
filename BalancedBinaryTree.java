/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    // return the height of subtree
    // -1 indicates subtree is not balanced
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        // if -1 occurs, all the tree is not balanced
        // just return -1 until root
        if (left == -1 || right == -1) return -1;
        int diff = Math.abs(left - right);
        if (diff > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}
