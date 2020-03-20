package linkedLists;

import java.util.ArrayList;

public class LinkedLists {
    ListNode removeDups(ListNode head) {
        if(head == null) return null;

        ArrayList<Integer> integers = new ArrayList<Integer>();
        ListNode finalList = null;
        ListNode current = new ListNode(head.val);

        while (head != null) {
            if (!integers.contains(head.val)) {
                integers.add(head.val);
                if (finalList == null) {
                    finalList = current;
                } else {
                    current.next = head;
                    current = head;
                }
            }

            head = head.next;
        }

        return finalList;
    }

    ListNode kthToLast(ListNode head, int kth) {
        int i = 1;
        while (kth != i && head != null) {
            head = head.next;
            i++;
        }

        return head;
    }
}
