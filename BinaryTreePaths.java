/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, path, paths);
        return paths;
    }

    public void dfs(TreeNode root, List<String> path, List<String> paths) {
        if (root.left == null && root.right == null) {
            path.add(String.valueOf(root.val));
            paths.add(String.join("->", path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(String.valueOf(root.val));
        if (root.left != null) dfs(root.left, path, paths);
        if (root.right != null) dfs(root.right, path, paths);
        path.remove(path.size() - 1);
    }
}
