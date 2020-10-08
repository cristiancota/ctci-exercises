package leetCode.challenge.october;

import linkedLists.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int listLength = getListLength(head);
        if (listLength < 2) {
            return head;
        }
        if (k >= listLength) {
            k = k % listLength;
        }
        for (int i = 0; i < k; i++) {
            head = rotate(head);
        }
        return head;
    }

    private int getListLength(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }

    public ListNode rotate(ListNode head) {
        ListNode originalHead = head;
        while (head != null) {
            ListNode next = head.next;
            if (next != null && next.next == null) { // is last element in the list
                next.next = originalHead;
                head.next = null;
                originalHead = next;
            }
            head = head.next;
        }
        return originalHead;
    }
}
