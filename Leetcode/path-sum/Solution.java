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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }
        int newSum = currentSum + root.val;
        if (root.left == null && root.right == null) {
            return targetSum == newSum;
        }
        return (hasPathSumHelper(root.left, targetSum, newSum) || hasPathSumHelper(root.right, targetSum, newSum));
    }
}
