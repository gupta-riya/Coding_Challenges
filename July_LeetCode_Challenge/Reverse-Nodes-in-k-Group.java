// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

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
    
    public ListNode reverseList(ListNode temp,ListNode nextPtr)
    {
        ListNode prev = null;
        ListNode curr = temp;
        ListNode end = nextPtr == null ? null : nextPtr.next;
        while(curr!=end)
        {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        
        return prev;
        
        
    }
    
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next==null || k==1)
            return head;
        
        ListNode tempHead = null;
        ListNode tempTail = null;
        
        ListNode temp = head;
        ListNode nextPtr = head;
        
        while(nextPtr!=null)
        {
            int count = 1;
            
            while(count < k && nextPtr!=null)
            {
                System.out.println(count + "\t" + nextPtr.val);
               
                nextPtr = nextPtr.next;
                if(nextPtr!=null)
                    count++;
            }
            
            if(count == k)
            {
                ListNode track = nextPtr==null?null:nextPtr.next;
                ListNode getNode = reverseList(temp,nextPtr);
                if(tempHead == null)
                {
                    tempHead = getNode;
                    tempTail = temp;
                }
                else
                {
                    tempTail.next = getNode;
                    tempTail = temp;
                }
                 
                temp = track;
                nextPtr = track;
                
            }
            else
            {
                tempTail.next = temp;
               
            }
            
        }
            
        return tempHead;
        
    }
}
