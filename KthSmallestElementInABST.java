/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] global = {0, 0};
        inorder(root, global, k);
        return global[1];
    }

    public void inorder(TreeNode root, int[] global, int k) {
        if (root.left != null) inorder(root.left, global, k);
        global[0]++;
        if (global[0] == k) {
            global[1] = root.val;
            return;
        }
        if (root.right != null) inorder(root.right, global, k);
    }
}