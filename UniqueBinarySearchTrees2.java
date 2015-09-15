/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int from, int to) {
        List<TreeNode> list = new ArrayList<>();
        if (from > to) {
            list.add(null);
            return list;
        }
        for (int mid = from; mid <= to; mid++) {
            List<TreeNode> leftTrees = buildTree(from, mid - 1);
            List<TreeNode> rightTrees = buildTree(mid + 1, to);
            for (int i = 0; i < leftTrees.size(); i++) {
                for (int j = 0; j < rightTrees.size(); j++) {
                    TreeNode root = new TreeNode(mid);
                    root.left = leftTrees.get(i);
                    root.right = rightTrees.get(j);
                    list.add(root);
                }
            }
        }
        return list;
    }
}
