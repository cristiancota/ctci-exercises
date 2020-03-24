package linkedLists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static linkedLists.ListNode.createListNode;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListsTest {

    @Test
    void testRemoveDuplicated() {
        LinkedLists linkedLists = new LinkedLists();
        ListNode expected = createListNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode actual = linkedLists.removeDups(createListNode(Arrays.asList(1, 2, 3, 4, 2, 5, 6)));
        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testKthToLast() {
        LinkedLists linkedLists = new LinkedLists();
        ListNode expected = createListNode(Arrays.asList(4, 5, 6));
        ListNode actual = linkedLists.kthToLast(createListNode(Arrays.asList(1, 2, 3, 4, 5, 6)), 4);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createListNode(Collections.singletonList(6));
        actual = linkedLists.kthToLast(createListNode(Arrays.asList(1, 2, 3, 4, 5, 6)), 6);

        assertTrue(linkedListsAreSame(expected, actual));

        assertNull(linkedLists.kthToLast(null, 1));
    }

    @Test
    void testPartition() {
        LinkedLists linkedLists = new LinkedLists();
        ListNode expected = createListNode(Arrays.asList(1, 2, 2, 4, 3, 5));
        ListNode actual = linkedLists.partition(createListNode(Arrays.asList(1, 4, 3, 2, 5, 2)), 3);
        assertTrue(linkedListsAreSame(expected, actual));

        actual = linkedLists.partition(createListNode(Arrays.asList(3, 5, 8, 5, 10, 2, 1)), 5);
        assertTrue(assertPartition(actual, 5));
    }

    @Test
    void testDeleteMiddleNode() {
        LinkedLists linkedLists = new LinkedLists();
        ListNode expected = createListNode(Arrays.asList(1, 3, 4, 5));
        ListNode actual = createListNode(Arrays.asList(1, 2, 3, 4, 5));

        assertFalse(linkedListsAreSame(expected, actual));

        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createListNode(Arrays.asList(1, 2));
        actual = createListNode(Arrays.asList(1, 2));
        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createListNode(Arrays.asList(1, 3));
        actual = createListNode(Arrays.asList(1, 2, 3));
        linkedLists.deleteMiddleNode(actual);

        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testSumLists() {
        LinkedLists linkedLists = new LinkedLists();
        ListNode expected = createListNode(Arrays.asList(2, 1, 9));
        ListNode first = createListNode(Arrays.asList(7, 1, 6));
        ListNode second = createListNode(Arrays.asList(5, 9, 2));
        ListNode actual = linkedLists.sumLists(first, second);

        assertTrue(linkedListsAreSame(expected, actual));

        expected = createListNode(Arrays.asList(5, 7, 3, 8));
        first = createListNode(Arrays.asList(4, 0, 1, 8));
        second = createListNode(Arrays.asList(1, 7, 2));
        actual = linkedLists.sumLists(first, second);

        assertTrue(linkedListsAreSame(expected, actual));
    }

    @Test
    void testIsPalindrome() {
        LinkedLists linkedLists = new LinkedLists();
        assertTrue(linkedLists.isPalindrome(createListNode(Arrays.asList(1, 2, 3, 2, 1))));
        assertFalse(linkedLists.isPalindrome(createListNode(Arrays.asList(1, 2, 3))));
        assertFalse(linkedLists.isPalindrome(createListNode(Arrays.asList(1, 3))));
        assertTrue(linkedLists.isPalindrome(createListNode(Collections.singletonList(1))));
        assertTrue(linkedLists.isPalindrome(createListNode(Arrays.asList(1,1,1,1))));
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
