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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalHelper(root, new ArrayList<>());
    }
    
    private List<Integer> preorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if(root.left != null) {
            result = preorderTraversalHelper(root.left, result);
        }
        if(root.right != null) {
            result = preorderTraversalHelper(root.right, result);
        }
        return result;
    }
}
