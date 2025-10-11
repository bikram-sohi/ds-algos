class MyLinkedList {
    private static class Node {
        Node next;
        int val;
        Node prev;
        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public MyLinkedList() {

    }
    
    public int get(int index) {
        Node cur = head;
        while(index > 0 && cur != null) {            
            cur = cur.next;
            index--;
        }
        return (cur == null) ? -1 : cur.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        if(index <= 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        while (index > 1 && cur != null) {
            cur = cur.next;
            index--;
        }
        if (cur == null) return;
        if (cur == tail) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        Node cur = head;
        while(index > 0 && cur != null) {
            cur = cur.next;
            index--;
        }
        if (cur == null) return;
        if (cur == head) {
            head = cur.next;
            if(head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
        else if (cur == tail) {
            tail = tail.prev;
            if(tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
        else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
