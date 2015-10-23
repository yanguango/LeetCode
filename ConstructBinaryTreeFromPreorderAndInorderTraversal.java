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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getRoot(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode getRoot(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1 || start2 > end2) return null;
        else if (start1 == end1) return new TreeNode(preorder[start1]);

        TreeNode root = new TreeNode(preorder[start1]);
        int leftCount = 0;
        while (start2 + leftCount <= end2 && inorder[start2 + leftCount] != preorder[start1]) {
            leftCount++;
        }
        root.left = getRoot(preorder, start1 + 1, start1 + leftCount, inorder, start2, start2 + leftCount - 1);
        root.right = getRoot(preorder, start1 + leftCount + 1, end1, inorder, start2 + leftCount + 1, end2);
        return root;

    }
}