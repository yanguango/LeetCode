/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] sum = new int[1];
        dfs(root, sum, 0);
        return sum[0];
    }

    public void dfs(TreeNode root, int[] sum, int path) {
        if (root.left == null && root.right == null) {
            sum[0] += path * 10 + root.val;
            return;
        }
        if (root.left != null) dfs(root.left, sum, path * 10 + root.val);
        if (root.right != null) dfs(root.right, sum, path * 10 + root.val);
    }
}
