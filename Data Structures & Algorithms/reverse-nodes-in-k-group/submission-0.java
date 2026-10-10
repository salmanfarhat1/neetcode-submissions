class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        int size = getSize(head);

        if (size < k)
            return head;

        ListNode prevStart = null;
        ListNode startNode = head;
        ListNode cur = head;

        int count = 0;

        while (cur != null) {

            count++;

            if (count == k) {

                ListNode nextStartNode = cur.next;

                ListNode newHead = reverse(startNode, k);

                if (prevStart != null) {
                    prevStart.next = newHead;
                } else {
                    head = newHead;
                }

                // startNode is now the tail
                startNode.next = nextStartNode;

                prevStart = startNode;
                startNode = nextStartNode;
                cur = nextStartNode;
                count = 0;

            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public int getSize(ListNode head) {
        int size = 0;

        while (head != null) {
            head = head.next;
            size++;
        }

        return size;
    }
}