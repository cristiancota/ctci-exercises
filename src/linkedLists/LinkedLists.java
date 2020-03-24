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

    void deleteMiddleNode(ListNode head) {
        boolean isFirst = true;
        ListNode prev = null;
        while (head != null) {
            if (isFirst) {
                isFirst = false;
            } else {
                if (head.next != null) {
                    prev.next = head.next;
                    break;
                }
            }
            prev = head;
            head = head.next;
        }
    }

    ListNode sumLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        ListNode nextHead;
        boolean isBiggerThanNine = false;

        while (A != null || B != null) {
            int aVal = A != null ? A.val : 0;
            int bVal = B != null ? B.val : 0;
            int aPlusB = aVal + bVal;

            if (isBiggerThanNine) {
                aPlusB += 1;
            }

            isBiggerThanNine = aPlusB > 9;
            head.val = aPlusB % 10;
            nextHead = new ListNode(0);
            head.next = nextHead;
            head = nextHead;
            A = A == null ? null : A.next;
            B = B != null ? B.next : null;
        }

        return result;
    }
}
