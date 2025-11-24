/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList();
        findDist(root, target, k);
        return res;
    }

    public int findDist(TreeNode root, TreeNode target, int k) {
        if(root == null) return -1;
        if(root == target) {
            if(k == 0) res.add(root.val);
            findNodes(root.left, 1, k);
            findNodes(root.right, 1, k);
            return 1;
        }
        int left = findDist(root.left, target, k);
        int right = findDist(root.right, target, k);
        if(left == k || right == k) {
            res.add(root.val);
        }
        if(left != -1) {
            findNodes(root.right, 1, k - left);
            return left + 1;
        }
        if(right != -1) {
            findNodes(root.left, 1, k - right);
            return right + 1;
        }
        return -1;
    }

    public void findNodes(TreeNode root, int cur, int dist) {
        if(root == null) return;
        if(cur == dist) {
            res.add(root.val);
            return;
        }
        else {
            findNodes(root.left, cur + 1, dist);
            findNodes(root.right, cur + 1, dist);
        }
    }
}
