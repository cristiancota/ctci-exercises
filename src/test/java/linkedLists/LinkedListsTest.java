package linkedLists;

import org.junit.jupiter.api.Test;

import static linkedLists.ListNode.createLinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListsTest {

    LinkedLists linkedLists = new LinkedLists();

    @Test
    void testRemoveDuplicated() {
        ListNode expected = createLinkedList(1, 2, 3, 4, 5, 6);
        ListNode actual = linkedLists.removeDups(createLinkedList(1, 2, 3, 4, 2, 5, 6));
        assertTrue(linkedListsAreSame(expected, actual));

        expected = createLinkedList(1, 2, 3);
        actual = linkedLists.removeDups(createLinkedList(1, 2, 3, 3, 2, 1, 3));
        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testKthToLast() {
        ListNode expected = createLinkedList(4, 5, 6);
        ListNode actual = linkedLists.kthToLast(createLinkedList(1, 2, 3, 4, 5, 6), 4);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createLinkedList(6);
        actual = linkedLists.kthToLast(createLinkedList(1, 2, 3, 4, 5, 6), 6);

        assertTrue(linkedListsAreSame(expected, actual));

        assertNull(linkedLists.kthToLast(null, 1));
    }

    @Test
    void testPartition() {
        ListNode expected = createLinkedList(1, 2, 2, 4, 3, 5);
        ListNode actual = linkedLists.partition(createLinkedList(1, 4, 3, 2, 5, 2), 3);
        assertTrue(linkedListsAreSame(expected, actual));

        actual = linkedLists.partition(createLinkedList(3, 5, 8, 5, 10, 2, 1), 5);
        assertTrue(assertPartition(actual, 5));
    }

    @Test
    void testDeleteMiddleNode() {
        ListNode expected = createLinkedList(1, 3, 4, 5);
        ListNode actual = createLinkedList(1, 2, 3, 4, 5);

        assertFalse(linkedListsAreSame(expected, actual));

        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createLinkedList(1, 2);
        actual = createLinkedList(1, 2);
        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createLinkedList(1, 3);
        actual = createLinkedList(1, 2, 3);
        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testSumLists() {
        ListNode expected = createLinkedList(2, 1, 9);
        ListNode first = createLinkedList(7, 1, 6);
        ListNode second = createLinkedList(5, 9, 2);
        ListNode actual = linkedLists.sumLists(first, second);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createLinkedList(5, 7, 3, 8);
        first = createLinkedList(4, 0, 1, 8);
        second = createLinkedList(1, 7, 2);
        actual = linkedLists.sumLists(first, second);

        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(linkedLists.isPalindrome(createLinkedList(1, 2, 3, 2, 1)));
        assertFalse(linkedLists.isPalindrome(createLinkedList(1, 2, 3)));
        assertFalse(linkedLists.isPalindrome(createLinkedList(1, 3)));
        assertTrue(linkedLists.isPalindrome(createLinkedList(1)));
        assertTrue(linkedLists.isPalindrome(createLinkedList(1, 1, 1, 1)));
    }

    @Test
    void testIntersection() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = c;
        c.next = f;

        // creating two linked lists intersecting on c
        // a > b > c < e < d
        //         v
        //         f

        assertEquals(c, linkedLists.intersection(a, d));
        assertNull(linkedLists.intersection(createLinkedList(1, 2, 3), createLinkedList(1, 2, 3)));
    }

    @Test
    void testLoopDetection() {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        assertEquals(c, linkedLists.loopDetection(a));
        assertNull(linkedLists.loopDetection(createLinkedList(1, 2, 3, 4, 5, 6, 7)));
    }

    private boolean linkedListsAreSame(ListNode expected, ListNode actual) {
        while (expected != null) {
            if (expected.val != actual.val)
                return false;

            expected = expected.next;
            actual = actual.next;
        }

        return true;
    }

    private boolean assertPartition(ListNode head, int partition) {
        boolean assertion = true;
        boolean isLeftSide = true;
        while (head != null) {
            if (head.val >= partition && isLeftSide) {
                isLeftSide = false;
            }

            if (!isLeftSide) {
                assertion = head.val >= partition;
            }

            head = head.next;
        }
        return assertion;
    }

}
