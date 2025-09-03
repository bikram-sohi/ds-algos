class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode current = root;

        while (current != null) {
            if (key < current.val) {
                parent = current;
                current = current.left;
            } else if (key > current.val) {
                parent = current;
                current = current.right;
            } else {
                if (current.left != null && current.right != null) {
                    TreeNode succParent = current;
                    TreeNode succ = current.right;
                    while (succ.left != null) {
                        succParent = succ;
                        succ = succ.left;
                    }
                    current.val = succ.val;
                    parent = succParent;
                    current = succ;
                }
                TreeNode child = (current.left != null) ? current.left : current.right;
                if (parent == null) {
                    root = child;
                } else if (parent.left == current) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                break;
            }
        }
        return root;
    }
}

