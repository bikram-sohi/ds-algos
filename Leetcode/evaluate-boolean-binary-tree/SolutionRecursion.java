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
    public boolean evaluateTree(TreeNode root) {
        return evaluateTreeHelper(root);
    }

    private boolean evaluateTreeHelper(TreeNode root) {
        if (root.val == 2) {
            return (evaluateTreeHelper(root.left) || evaluateTreeHelper(root.right));
        }
        else if (root.val == 3) {
            return (evaluateTreeHelper(root.left) && evaluateTreeHelper(root.right));
        }
        else if (root.val == 1) {
            return true;
        }
        else if (root.val == 0) {
            return false;
        }
        return false;
    }
}
