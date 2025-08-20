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
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    private int maxDepthHelper(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        }
        return Math.max(maxDepthHelper(root.left, currentDepth + 1), maxDepthHelper(root.right, currentDepth + 1));
    }
}
