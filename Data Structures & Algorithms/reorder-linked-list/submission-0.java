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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
         
        ListNode reversedList = slow.next; 

        slow.next = null;
        reversedList = reverse(reversedList);

        ListNode curNode1 = head; 
        ListNode curNode2 = reversedList; 

        while(curNode1 != null && curNode2 != null){
            ListNode next1 = curNode1.next; 
            ListNode next2 = curNode2.next; 
            curNode1.next = curNode2; 
            curNode2.next = next1; 
            curNode1 = next1; 
            curNode2 = next2;             
        }
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head; 

        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;

        while(cur != null){
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;   
        }

        return prev;
    }
}

