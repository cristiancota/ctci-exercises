package leetCode;


import linkedLists.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbersNotWorking(ListNode l1, ListNode l2) {
        long numberResult = getNumberFromListNode(l1) + getNumberFromListNode(l2);
        ListNode result = null;
        ListNode newHead = null;

        while (numberResult > 0) {
            int currentNumber = Math.toIntExact(numberResult % 10);

            if (result == null) {
                result = new ListNode(currentNumber);
                newHead = result;
            } else {
                ListNode current = new ListNode(currentNumber);
                newHead.next = current;
                newHead = current;
            }

            numberResult -= currentNumber;
            numberResult /= 10;
        }

        return result == null ? new ListNode(0) : result;
    }

    public long getNumberFromListNode(ListNode node) {
        long multiplier = 1;
        long result = 0;

        while (node != null) {
            result += node.val * multiplier;
            node = node.next;
            multiplier *= 10;
        }

        return result;
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

    int getListLength(ListNode list) {
        int counter = 0;
        while (list != null) {
            ++counter;
            list = list.next;
        }
        return counter;
    }
}
