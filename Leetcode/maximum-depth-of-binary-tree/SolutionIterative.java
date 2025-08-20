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
import java.util.*;

class Level {
    TreeNode root;
    int depth;

    public Level (TreeNode root, int depth) {
        this.root = root;
        this.depth = depth;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        List<Level> stack = new ArrayList<Level>();
        stack.add(new Level(root, 0));
        while(stack.size() > 0) {
            Level currentLevel = stack.remove(stack.size() - 1);
            maxDepth = Math.max(maxDepth, currentLevel.depth);
            if (currentLevel.root == null) {
                continue;
            }
            stack.add(new Level(currentLevel.root.left, currentLevel.depth + 1));
            stack.add(new Level(currentLevel.root.right, currentLevel.depth + 1));
        }
        return maxDepth;
    }
}
