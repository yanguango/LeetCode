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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getRoot(nums, 0, nums.length - 1);
    }

    public TreeNode getRoot(int[] nums, int start, int end) {
        if (start > end) return null;
        else if (start == end) return new TreeNode(nums[start]);

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getRoot(nums, start, mid - 1);
        root.right = getRoot(nums, mid + 1, end);
        return root;
    }
}