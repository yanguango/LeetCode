/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, res, path);
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> p = new ArrayList<>(path);
            p.add(root.val);
            res.add(p);
            return;
        }

        path.add(root.val);
        if (root.left != null) dfs(root.left, sum - root.val, res, path);
        if (root.right != null) dfs(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}
