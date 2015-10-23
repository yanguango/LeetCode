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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = {0};
        isUnivalue(root, count);
        return count[0];
    }

    public boolean isUnivalue(TreeNode root, int[] count) {
        if (root == null) return true;
        boolean leftIs = isUnivalue(root.left, count);
        boolean rightIs = isUnivalue(root.right, count);
        boolean is = false;
        if (leftIs && rightIs) {
            if ((root.left != null && root.right != null && root.left.val == root.val && root.right.val == root.val)
                    || (root.left != null && root.right == null && root.left.val == root.val)
                    || (root.left == null && root.right != null && root.right.val == root.val)
                    || (root.left == null && root.right == null)) {
                count[0]++;
                is = true;
            }
        }
        return is;
    }
}

public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = {0};
        isUnivalue(root, 0, count);
        return count[0];
    }

    public boolean isUnivalue(TreeNode root, int value, int[] count) {
        if (root == null) return true;
        boolean leftIs = isUnivalue(root.left, root.val, count);
        boolean rightIs = isUnivalue(root.right, root.val, count);
        if (!leftIs || !rightIs) return false;
        count[0]++;
        return root.val == value;
    }
}