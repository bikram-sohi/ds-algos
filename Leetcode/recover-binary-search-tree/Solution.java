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
    TreeNode one = null;
    TreeNode two = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
        return;
    }

    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(prev != null && root.val < prev.val) {
            if(one == null) {
                one = prev;
            }
            two = root;
        }
        prev = root;
        helper(root.right);
        return;
    }
}
