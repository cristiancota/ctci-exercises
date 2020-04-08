package treesAndGraphs;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TreesAndGraphsTest {

    @Test
    void testInOrderTraversal() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        treesAndGraphs.inOrderTraversal(root);
    }

    @Test
    void testPreOrderTraversal() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        treesAndGraphs.preOrderTraversal(root);
    }

    @Test
    void testPostOrderTraversal() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        treesAndGraphs.postOrderTraversal(root);
    }

    @Test
    void testIsRouteBetweenNodes() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);

        GraphNode[] adjacent1 = new GraphNode[1];
        adjacent1[0] = node2;
        node1.adjacent = adjacent1;

        GraphNode[] adjacent2 = new GraphNode[2];
        adjacent2[0] = node3;
        adjacent2[1] = node4;
        node2.adjacent = adjacent2;

        GraphNode[] adjacent3 = new GraphNode[2];
        adjacent3[0] = node4;
        adjacent3[1] = node5;
        node3.adjacent = adjacent3;

        node4.adjacent = new GraphNode[0];

        GraphNode[] adjacent5 = new GraphNode[1];
        adjacent5[0] = node1;
        node5.adjacent = adjacent5;

        assertTrue(treesAndGraphs.isRouteBetweenNodes(node1, node2));
        assertFalse(treesAndGraphs.isRouteBetweenNodes(node4, node2));
        assertTrue(treesAndGraphs.isRouteBetweenNodes(node5, node4));
        assertTrue(treesAndGraphs.isRouteBetweenNodes(node3, node2));
    }

    @Test
    void testMinimalTree() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode actual = treesAndGraphs.minimalTree(new int[]{1, 2, 3, 4, 5});
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(1);
        expected.left.right = new TreeNode(2);
        expected.right = new TreeNode(4);
        expected.right.right = new TreeNode(5);

        treesAreTheSame(expected, actual);
    }

    @Test
    void testListOfDepths() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode tree = TreeNode.createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        List<LinkedList<Integer>> actual = treesAndGraphs.listOfDepths(tree);

        List<LinkedList<Integer>> expected = new ArrayList<>();
        expected.add(new LinkedList<>(Collections.singletonList(1)));
        expected.add(new LinkedList<>(Arrays.asList(2, 3)));
        expected.add(new LinkedList<>(Arrays.asList(4, 5, 6, 7)));

        assertEquals(expected.size(), actual.size());
        assertLinkedListsEquals(expected, actual);

        tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.left.right = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.right.right = new TreeNode(5);

        actual = treesAndGraphs.listOfDepths(tree);

        expected = new ArrayList<>();
        expected.add(new LinkedList<>(Collections.singletonList(3)));
        expected.add(new LinkedList<>(Arrays.asList(1, 4)));
        expected.add(new LinkedList<>(Arrays.asList(2, 5)));

        assertEquals(expected.size(), actual.size());
        assertLinkedListsEquals(expected, actual);
    }

    private void assertLinkedListsEquals(List<LinkedList<Integer>> expected, List<LinkedList<Integer>> actual) {
        for (int i = 0; i < expected.size(); i++) {
            LinkedList<Integer> currentExpected = expected.get(i);
            LinkedList<Integer> currentActual = actual.get(i);
            while ((currentExpected.peek() != null && currentActual.peek() != null)) {
                assertEquals(currentExpected.pop(), currentActual.pop());
            }
        }
    }

    private void treesAreTheSame(TreeNode expected, TreeNode actual) {
        if (expected == null && actual != null) {
            throw new AssertionFailedError("Expected is null and actual has value", null, actual.value);
        }

        if (actual == null && expected != null) {
            throw new AssertionFailedError("Actual is null and expected has value", expected.value, null);
        }

        if (actual != null) {
            assertEquals(expected.value, actual.value);
            treesAreTheSame(expected.left, actual.left);
            treesAreTheSame(expected.right, actual.right);
        }
    }

    @Test
    void testAssertTreesAreTheSame() {
        TreeNode actual = TreeNode.createTree(new int[]{1, 2, 3});
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);

        treesAreTheSame(expected, actual);

        assertThrows(AssertionFailedError.class, () -> {
            TreeNode expectedToFail = new TreeNode(1);
            TreeNode actualToFail = TreeNode.createTree(new int[]{1, 2, 3, 4, 5});
            treesAreTheSame(expectedToFail, actualToFail);
        });

        assertThrows(AssertionFailedError.class, () -> {
            TreeNode expectedToFail = new TreeNode(1);
            TreeNode actualToFail = TreeNode.createTree(new int[]{2});
            treesAreTheSame(expectedToFail, actualToFail);
        });
    }
}
