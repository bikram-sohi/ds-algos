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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversalHelper(root, new ArrayList<>());
    }

    private List<Integer> inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if(root.left != null) {
            result = inorderTraversalHelper(root.left, result);
        }
        result.add(root.val);
        if(root.right != null) {
            result = inorderTraversalHelper(root.right, result);
        }
        return result;
    }
}
