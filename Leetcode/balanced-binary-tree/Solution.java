/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null || result == false) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        result = result && (Math.abs(left - right) <= 1);
        return Math.max(left, right) + 1;
    }
}
