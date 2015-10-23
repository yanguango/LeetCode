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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = root.left;
        TreeNode left = root.right;
        TreeNode right = root;
        root.left = null;
        root.right = null;
        while (newRoot != null) {
            TreeNode nextRoot = newRoot.left;
            TreeNode newLeft = newRoot.right;
            newRoot.right = right;
            newRoot.left = left;
            left = newLeft;
            right = newRoot;
            if (nextRoot == null) break;
            newRoot = nextRoot;
        }
        return newRoot;
    }
}