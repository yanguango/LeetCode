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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getRoot(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode getRoot(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        else if (is == ie) return new TreeNode(inorder[is]);

        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int leftCount = 0;
        while (is + leftCount <= ie && inorder[is + leftCount] != rootVal) {
            leftCount++;
        }
        root.left = getRoot(inorder, is, is + leftCount - 1, postorder, ps, ps + leftCount - 1);
        root.right = getRoot(inorder, is + leftCount + 1, ie, postorder, ps + leftCount, pe - 1);
        return root;
    }
}