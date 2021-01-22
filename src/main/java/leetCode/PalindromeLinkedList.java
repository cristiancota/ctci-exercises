package leetCode;

import linkedLists.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode original = head;

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != original.val) {
                return false;
            }
            original = original.next;
        }

        return true;
    }
}
