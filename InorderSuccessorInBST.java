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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        TreeNode node = root;
        while (node != p) {
            if (node.val > p.val) {
                succ = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node.right != null)  {
            succ = node.right;
            while (succ != null && succ.left != null) succ = succ.left;
        }
        return succ;
    }
}
