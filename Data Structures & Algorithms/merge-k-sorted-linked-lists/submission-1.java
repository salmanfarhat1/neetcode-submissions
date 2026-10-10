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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> {return a.val - b.val; }
        );

        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }
        ListNode head = new ListNode(-1 );
        ListNode cur = head;
        while(!pq.isEmpty()){
            ListNode node  = pq.poll();
            cur.next = node; 
            cur = cur.next;
            if(node.next != null )
                pq.add(node.next);
        }
        return head.next;
    }
}