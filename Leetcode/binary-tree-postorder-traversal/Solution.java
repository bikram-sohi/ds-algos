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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversalHelper(root, new ArrayList<>());
    }
    
    private List<Integer> postorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if(root.left != null) {
            result = postorderTraversalHelper(root.left, result);
        }
        if(root.right != null) {
            result = postorderTraversalHelper(root.right, result);
        }
        result.add(root.val);
        return result;
    }
}
