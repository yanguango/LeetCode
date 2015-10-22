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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        search(root, max);
        return max[0];
    }

    public int search(TreeNode root, int[] max) {
        if (root == null) return Integer.MIN_VALUE;
        int leftMax = search(root.left, max);
        int rightMax = search(root.right, max);
        int maxHere = root.val;
        if (Math.max(leftMax, rightMax) > 0) {
            maxHere = maxHere + Math.max(leftMax, rightMax);
        }
        int maxPath = root.val;
        if (leftMax > 0) maxPath += leftMax;
        if (rightMax > 0) maxPath += rightMax;
        max[0] = Math.max(maxPath, max[0]);
        return maxHere;
    }
}