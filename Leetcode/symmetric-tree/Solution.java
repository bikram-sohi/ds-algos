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

import java.util.Stack;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        leftStack.push(root.left);
        rightStack.push(root.right);

        while(!leftStack.empty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();

            if (left == null && right == null) {
                continue;
            } else if(left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            leftStack.push(left.left);
            rightStack.push(right.right);
            leftStack.push(left.right);
            rightStack.push(right.left);
        }
        
        return true;
    }
}
