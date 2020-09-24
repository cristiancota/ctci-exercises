package leetCode;

import linkedLists.ListNode;

public class MergeSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        ListNode prevAns = null;
        while (true) {
            int indexMinor = -1;
            int currentMinor = Integer.MAX_VALUE;

            for (int i = 0, listsLength = lists.length; i < listsLength; i++) {
                ListNode currentList = lists[i];
                if (currentList == null) {
                    continue;
                }
                if (currentList.val < currentMinor) {
                    indexMinor = i;
                    currentMinor = currentList.val;
                }
            }

            if (indexMinor != -1) {
                if (ans == null) {
                    ans = new ListNode(lists[indexMinor].val);
                    prevAns = ans;
                } else {
                    ListNode element = new ListNode(lists[indexMinor].val);
                    prevAns.next = element;
                    prevAns = element;
                }
                ListNode next = lists[indexMinor].next;
                lists[indexMinor] = next;
            } else {
                break;
            }
        }
        return ans;
    }
}
