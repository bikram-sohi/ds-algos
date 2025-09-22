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
    int treeSum = 0;
    long maxProduct = 0;

    void getSum(TreeNode root) {
        if (root == null) {
            return;
        }
        treeSum += root.val;
        getSum(root.left);
        getSum(root.right);
    }

    long getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        long left = getMaxSum(root.left);
        long right = getMaxSum(root.right);
        
        long subTreeSum = root.val + left + right;
        
        maxProduct = Math.max(maxProduct, (treeSum - subTreeSum) * (subTreeSum));

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        getSum(root);
        getMaxSum(root);
        return (int)(maxProduct % (int)(1e9 + 7));     
    }
}
