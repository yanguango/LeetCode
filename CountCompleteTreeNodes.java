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
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int leftHeight(TreeNode root) {
        int height = 0;
        TreeNode node = root;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public int rightHeight(TreeNode root) {
        int height = 0;
        TreeNode node = root;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}