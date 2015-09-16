/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        preorder(root, prev);
    }

    public void preorder(TreeNode root, TreeNode[] prev) {
        if (root == null) return;
        TreeNode left = root == null ? null : root.left;
        TreeNode right = root == null ? null : root.right;
        if (prev[0] != null) {
            prev[0].right = root;
            prev[0].left = null;
        }
        prev[0] = root;
        preorder(left, prev);
        preorder(right, prev);
    }
}
