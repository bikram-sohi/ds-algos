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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafVals1 = new ArrayList<>();
        List<Integer> leafVals2 = new ArrayList<>();

        fillNodes(root1, leafVals1);
        fillNodes(root2, leafVals2);

        return leafVals1.equals(leafVals2);
    }

    void fillNodes(TreeNode node, List<Integer> leafVals) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            leafVals.add(node.val);
        }
        fillNodes(node.left, leafVals);
        fillNodes(node.right, leafVals);
    }
}
