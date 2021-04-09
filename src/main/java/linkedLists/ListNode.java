package linkedLists;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createLinkedList(Integer... integers) {
        if (integers.length == 0) return null;

        ListNode head = new ListNode(0); // dummy head
        ListNode linkedList = head; // actual list

        for (Integer integer : integers) {
            head.next = new ListNode(integer);
            head = head.next;
        }

        return linkedList.next; // remove dummy head
    }
}