class MinStack {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    Node head;
    Node minHead;

    public MinStack() {
        head = null;
        minHead = null;
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val);
            minHead = new Node(val);
        }
        else {
            Node tempH = new Node(val);
            Node tempM = new Node(Math.min(val, minHead.val));
            tempH.next = head;
            head = tempH;
            tempM.next = minHead;
            minHead = tempM;
        }
    }
    
    public void pop() {
        if(head != null) {
            head = head.next;
            minHead = minHead.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return minHead.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
