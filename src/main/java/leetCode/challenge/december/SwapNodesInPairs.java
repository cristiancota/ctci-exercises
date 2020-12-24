package leetCode.challenge.december;

import linkedLists.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        newHead.next.next = swapPairs(newHead.next.next);

        return newHead;
    }
}
