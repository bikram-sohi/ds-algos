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
    int rootIdx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private TreeNode bstFromPreorderHelper(int[] preorder, int upper, int lower) {
        if (rootIdx < preorder.length && preorder[rootIdx] < upper && preorder[rootIdx] > lower) {
            int currentVal = preorder[rootIdx];
            TreeNode newNode = new TreeNode(currentVal);
            rootIdx++;
            newNode.left = bstFromPreorderHelper(preorder, currentVal, lower);
            newNode.right = bstFromPreorderHelper(preorder, upper, currentVal);
            return newNode;
        } else {
            return null;
        }
    }
}
