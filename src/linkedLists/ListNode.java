package linkedLists;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    static ListNode createListNode(List<Integer> list) {
        if (list.isEmpty()) return null;

        ListNode head = new ListNode(list.get(0));
        ListNode el;
        ListNode theList = head;

        for (int i = 1; i < list.size(); i++) {
            el = new ListNode(list.get(i));
            head.next = el;
            head = el;
        }

        return theList;
    }
}