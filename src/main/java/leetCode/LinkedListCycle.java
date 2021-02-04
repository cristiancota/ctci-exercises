package leetCode;

import linkedLists.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
