/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        while(p1 != null) {
            while(p1.next != null && p1.next.val == p1.val) {
                p1.next = p1.next.next;
            }
            p1 = p1.next;
        }
        return head;
    }
}
