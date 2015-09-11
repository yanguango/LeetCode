/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = 0;
        double difference = Double.MAX_VALUE;
        TreeNode node = root;
        while (node != null) {
            if (node.val == target) return node.val;
            if (Math.abs(node.val - target) < difference) {
                difference = Math.abs(node.val - target);
                closest = node.val;
            }
            if (node.val < target) node = node.right;
            else node = node.left;
        }
        return closest;
    }
}
