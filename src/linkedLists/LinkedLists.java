package linkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedLists {
    ListNode removeDups(ListNode head) {
        if (head == null) return null;

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

    ListNode partition(ListNode head, int x) {
        List<Integer> smallers = new ArrayList<Integer>();
        List<Integer> greaters = new ArrayList<Integer>();

        while (head != null) {
            if (head.val < x) {
                smallers.add(head.val);
            } else {
                greaters.add(head.val);
            }

            head = head.next;
        }

        ListNode toReturn = null;
        ListNode newHead = null;

        for (Integer current : smallers) {
            if (toReturn == null) {
                toReturn = new ListNode(current);
                newHead = toReturn;
            } else {
                ListNode newNode = new ListNode(current);
                newHead.next = newNode;
                newHead = newNode;
            }
        }

        for (Integer current : greaters) {
            if (toReturn == null) {
                toReturn = new ListNode(current);
                newHead = toReturn;
            } else {
                ListNode newNode = new ListNode(current);
                newHead.next = newNode;
                newHead = newNode;
            }
        }

        return toReturn;
    }
}
