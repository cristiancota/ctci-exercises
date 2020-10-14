package leetCode.challenge.october;

import linkedLists.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        ListNode ans = new ListNode(list.get(0));
        ListNode currentHead = ans;

        for (int i = 1; i < list.size(); i++) {
            ListNode next = new ListNode(list.get(i));
            currentHead.next = next;
            currentHead = next;
        }

        return ans;
    }
}
