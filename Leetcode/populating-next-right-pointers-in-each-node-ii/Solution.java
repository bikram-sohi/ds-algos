/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        fillNext(root);
        return root;
    }
    void fillNext(Node root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            }
            else {
                root.left.next = getNextPossibleChild(root);
            }
        }
        if(root.right != null) {
            root.right.next = getNextPossibleChild(root);
        }

        fillNext(root.right);
        fillNext(root.left);
    }

    public Node getNextPossibleChild(Node root) {
        while(root.next != null) {
            if(root.next.left != null) {
                return root.next.left;
            }
            if(root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
