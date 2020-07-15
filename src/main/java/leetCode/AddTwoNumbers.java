package leetCode;

import linkedLists.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length = getListLength(l1);
        int l2Length = getListLength(l2);
        ListNode result = null;
        ListNode aux = null;
        int excess = 0;

        for (int i = 0; i < Math.max(l1Length, l2Length) || excess > 0; i++) {
            int total = excess;
            if (i < l1Length) {
                total += l1.val;
                l1 = l1.next;
            }

            if (i < l2Length) {
                total += l2.val;
                l2 = l2.next;
            }

            if (total >= 10) {
                total = total % 10;
                excess = 1;
            } else {
                excess = 0;
            }

            if (result == null) {
                result = new ListNode(total);
                aux = result;
            } else {
                ListNode listNode = new ListNode(total);
                aux.next = listNode;
                aux = listNode;
            }
        }

        return result;
    }

    private int getListLength(ListNode list) {
        int counter = 0;
        while (list != null) {
            ++counter;
            list = list.next;
        }
        return counter;
    }
}
