/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        else if (leftNode == null || rightNode == null) return false;
        else {
            if (leftNode.val != rightNode.val) return false;
            else return check(leftNode.right, rightNode.left)
                            && check(leftNode.left, rightNode.right);
        }

    }
}
