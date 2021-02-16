package leetCode;

import linkedLists.ListNode;

import java.util.HashSet;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleII(ListNode head) {
        /*
        * Two pointers.
        * If there's a cycle the fast will be null at some point, returning false.
        * Otherwise slow and fast will eventually be the same.
        * */
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
