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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[] {0};
        dfs(root, root.val - 1, 0, max);
        return max[0];
    }

    public void dfs(TreeNode root, int parent, int localLen, int[] max) {
        if (root == null) return;
        if (root.val == parent + 1) {
            max[0] = Math.max(max[0], localLen + 1);
            dfs(root.left, root.val, localLen + 1, max);
            dfs(root.right, root.val, localLen + 1, max);
        } else {
            dfs(root.left, root.val, 1, max);
            dfs(root.right, root.val, 1, max);
        }
    }
}