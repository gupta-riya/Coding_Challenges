// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
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
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;   
        ListNode curr = head;

        while (curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    
    
    
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        
        if (left == right)
        return head;

       
        ListNode revs = null, revs_prev = null;
        ListNode revend = null, revend_next = null;

        
        int i = 1;
        ListNode curr = head;
        while (curr!=null && i <= right) {
            if (i < left)
                revs_prev = curr;

            if (i == left)
                revs = curr;

            if (i == right) {
                revend = curr;
                revend_next = curr.next;
            }

            curr = curr.next;
            i++;
        }
        revend.next = null;

        
        revend = reverse(revs);

        
        if (revs_prev!=null)
            revs_prev.next = revend;

       
        else
            head = revend;

        revs.next = revend_next;
        return head;
        
    }
}
