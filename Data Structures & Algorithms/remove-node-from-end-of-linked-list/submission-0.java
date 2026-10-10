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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head  = reverse(head);
        int i =0;
        ListNode preHead = new ListNode(-1); 
        ListNode cur = preHead; 
        preHead.next = head; 
        while(i < n){
            if(i == (n -1)){
                ListNode prev= cur; 
                cur = cur.next.next; 
                prev.next= cur; 
                break; 
            }  
            i++; 
            cur = cur.next;
        }
        
        return reverse(preHead.next); 

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
        cur = curNext;       // ✅
    }

    return prev;
}
}
