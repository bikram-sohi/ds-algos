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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();

        first.push(root1);
        second.push(root2);

        while(!first.empty()) {
            TreeNode firstNode = first.pop();
            TreeNode secondNode = second.pop();

            if (secondNode == null) {
                continue;
            }

            firstNode.val += secondNode.val;
            
            if (firstNode.left == null) {
                firstNode.left = secondNode.left;
            } else {
                first.push(firstNode.left);
                second.push(secondNode.left);
            }

            if (firstNode.right == null) {
                firstNode.right = secondNode.right;
            } else {
                first.push(firstNode.right);
                second.push(secondNode.right);
            }
        }
        return root1;
    }
}
