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
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) return result;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int level = 0;
//         while(!queue.isEmpty()) {
//             List<Integer> row = new ArrayList<>();
//             int n = queue.size();
//             for(int i = 0; i < n; i++) {
//                 TreeNode current = queue.poll();
//                 row.add(current.val);
//                 if(current.left != null) queue.offer(current.left);
//                 if(current.right != null) queue.offer(current.right);
//             }
//             result.add(row);
//         }
//         return result;
//     }
// }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    void helper(TreeNode root, int level, List<List<Integer>> result){
        if(root == null) {
            return;
        }
        
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
}
