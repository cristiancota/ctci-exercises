package linkedLists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedLists {
    ListNode removeDups(ListNode head) {
//        if (head == null) return null;
//
//        ArrayList<Integer> integers = new ArrayList<>();
//        ListNode finalList = null;
//        ListNode current = new ListNode(head.val);
//
//        while (head != null) {
//            if (!integers.contains(head.val)) {
//                integers.add(head.val);
//                if (finalList == null) {
//                    finalList = current;
//                } else {
//                    current.next = head;
//                    current = head;
//                }
//            }
//
//            head = head.next;
//        }
//
//        return finalList;
        ListNode ans = head;
        while (head != null) {
            removeDupsHelper(head.val, head.next, head); // enter a step forward
            head = head.next;
        }
        return ans;
    }

    private void removeDupsHelper(int target, ListNode current, ListNode prev) {
        while (current != null) {
            if (current.val == target) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
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
        List<Integer> little = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        while (head != null) {
            if (head.val < x) {
                little.add(head.val);
            } else {
                big.add(head.val);
            }

            head = head.next;
        }

        ListNode ans = null;
        ListNode currentHead = null;

        for (Integer current : little) {
            if (ans == null) {
                ans = new ListNode(current);
                currentHead = ans;
            } else {
                ListNode newNode = new ListNode(current);
                currentHead.next = newNode;
                currentHead = newNode;
            }
        }

        for (Integer current : big) {
            if (ans == null) {
                ans = new ListNode(current);
                currentHead = ans;
            } else {
                ListNode newNode = new ListNode(current);
                currentHead.next = newNode;
                currentHead = newNode;
            }
        }

        return ans;
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

    ListNode sumLists(ListNode headA, ListNode headB) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        ListNode nextHead;
        boolean isBiggerThanNine = false;

        while (headA != null || headB != null) {
            int aVal = headA != null ? headA.val : 0;
            int bVal = headB != null ? headB.val : 0;
            int aPlusB = aVal + bVal;

            if (isBiggerThanNine) {
                aPlusB += 1;
            }

            isBiggerThanNine = aPlusB > 9;
            head.val = aPlusB % 10;
            nextHead = new ListNode(0);
            head.next = nextHead;
            head = nextHead;
            headA = headA == null ? null : headA.next;
            headB = headB != null ? headB.next : null;
        }

        return result;
    }

    boolean isPalindrome(ListNode headA) {
        List<Integer> integers = new ArrayList<>();
        while (headA != null) {
            integers.add(headA.val);
            headA = headA.next;
        }

        for (int i = 0; i < integers.size(); i++) {
            if (!integers.get(i).equals(integers.get(integers.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    ListNode intersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        List<ListNode> allNodes = new ArrayList<>();

        while (headA != null) {
            allNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (allNodes.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    ListNode loopDetection(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
