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
    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return result;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root.left != null) {
            kthSmallestHelper(root.left, k);
        }
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        if (root.right != null) {
            kthSmallestHelper(root.right, k);
        }
        return;
    }
}
