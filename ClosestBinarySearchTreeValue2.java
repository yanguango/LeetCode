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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        travesal(res, root);
        Collections.sort(res, new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return Double.compare(Math.abs(int1 - target), Math.abs(int2 - target));
            }
        });

        return res.subList(0, k);
    }

    public void travesal(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        travesal(list, root.left);
        travesal(list, root.right);
    }
}
