package linkedLists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static linkedLists.ListNode.createListNode;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListsTest {

    @Test
    void testRemoveDups() {
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
        ListNode expected = createListNode(Arrays.asList(1,2,2,4,3,5));
        ListNode actual = linkedLists.partition(createListNode(Arrays.asList(1,4,3,2,5,2)), 3);
        assertTrue(linkedListsAreSame(expected, actual));

        // Not passing ctci example:
        // input    3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
        // output   3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
        // TODO create assertion where every element until x are smaller than X, and after they're equal or greater
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

}
