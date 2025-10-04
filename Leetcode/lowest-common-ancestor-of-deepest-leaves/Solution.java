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
    class Result {
        int depth;
        TreeNode node;
        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    Result dfs(TreeNode node) {
        if (node == null) return new Result(-1, null);
        
        Result left = dfs(node.left);
        Result right = dfs(node.right);

        int depth = Math.max(left.depth, right.depth) + 1;

        if (left.depth == right.depth) {
            return new Result(depth, node);
        } else if (left.depth > right.depth) {
            return new Result(depth, left.node);
        } else {
            return new Result(depth, right.node);
        }
    }
}
