package treesAndGraphs;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static treesAndGraphs.TreeNode.createTree;

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
        TreeNode tree = createTree(new int[]{1, 2, 3, 4, 5, 6, 7});
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
            throw new AssertionFailedError("Expected is null and actual has value", null, actual.val);
        }

        if (actual == null && expected != null) {
            throw new AssertionFailedError("Actual is null and expected has value", expected.val, null);
        }

        if (actual != null) {
            assertEquals(expected.val, actual.val);
            treesAreTheSame(expected.left, actual.left);
            treesAreTheSame(expected.right, actual.right);
        }
    }

    @Test
    void testAssertTreesAreTheSame() {
        TreeNode actual = createTree(new int[]{1, 2, 3});
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);

        treesAreTheSame(expected, actual);

        assertThrows(AssertionFailedError.class, () -> {
            TreeNode expectedToFail = new TreeNode(1);
            TreeNode actualToFail = createTree(new int[]{1, 2, 3, 4, 5});
            treesAreTheSame(expectedToFail, actualToFail);
        });

        assertThrows(AssertionFailedError.class, () -> {
            TreeNode expectedToFail = new TreeNode(1);
            TreeNode actualToFail = createTree(new int[]{2});
            treesAreTheSame(expectedToFail, actualToFail);
        });
    }

    @Test
    void testIsBalanced() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode tree = new TreeNode(1);
        assertTrue(treesAndGraphs.isBalanced(tree));

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);

        assertTrue(treesAndGraphs.isBalanced(tree));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        assertFalse(treesAndGraphs.isBalanced(root));
    }

    @Test
    void testIsBinarySearchTree() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        assertFalse(treesAndGraphs.validateBST(createTree(new int[]{1, 2, 3, 4})));
        assertTrue(treesAndGraphs.validateBST(createTree(new int[]{2, 1, 3})));
        assertTrue(treesAndGraphs.validateBST(createTree(new int[]{20, 10, 24, 1, 15, 22, 50})));

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(24);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(50);
        root.right.right.left = new TreeNode(48);

        assertTrue(treesAndGraphs.validateBST(root));

        root = new TreeNode(1);
        root.left = new TreeNode(1);

        assertFalse(treesAndGraphs.validateBST(root));

        root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(24);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(50);
        root.right.right.left = new TreeNode(3);

        assertFalse(treesAndGraphs.validateBST(root));
    }

    @Test
    void testSuccessor() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(24);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(50);

        int successor = treesAndGraphs.successor(root, 15);
        assertEquals(20, successor);

        successor = treesAndGraphs.successor(root, 24);
        assertEquals(50, successor);

        successor = treesAndGraphs.successor(root, 1);
        assertEquals(10, successor);

        root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        successor = treesAndGraphs.successor(root, 8);
        assertEquals(10, successor);

        successor = treesAndGraphs.successor(root, 10);
        assertEquals(12, successor);

        successor = treesAndGraphs.successor(root, 14);
        assertEquals(20, successor);
    }

    @Test
    void testBuildOrder() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        String[] array = treesAndGraphs.buildOrder(new String[]{"a", "b", "c", "d", "e", "f"}, new String[][]{
                {"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}
        });

        assertArrayEquals(new String[]{"e", "f", "a", "b", "d", "c"}, array);
    }

    @Test
    void testFindCommonAncestor() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.right.left.right = new TreeNode(10);

        assertEquals(3, treesAndGraphs.findCommonAncestor(tree, 10, 7));
        assertEquals(2, treesAndGraphs.findCommonAncestor(tree, 8, 2));
        assertEquals(2, treesAndGraphs.findCommonAncestor(tree, 5, 8));

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(5);
        tree2.right = new TreeNode(1);
        tree2.left.left = new TreeNode(6);
        tree2.left.right = new TreeNode(2);
        tree2.right.left = new TreeNode(0);
        tree2.right.right = new TreeNode(8);
        tree2.left.right.left = new TreeNode(7);
        tree2.left.right.right = new TreeNode(4);

        assertEquals(3, treesAndGraphs.findCommonAncestor(tree2, 6, 0));
        assertEquals(3, treesAndGraphs.findCommonAncestor(tree2, 7, 8));
    }

    @Test
    void testGetParents() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.right.right = new TreeNode(10);

        assertEquals(Arrays.asList(2, 1), treesAndGraphs.getParents(tree, 5));
        assertEquals(Arrays.asList(3, 1), treesAndGraphs.getParents(tree, 7));
        assertEquals(Arrays.asList(7, 3, 1), treesAndGraphs.getParents(tree, 10));
    }

    @Test
    void testTreesAreTheSame() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        assertTrue(treesAndGraphs.treesAreTheSame(new TreeNode(1), new TreeNode(1)));
        assertFalse(treesAndGraphs.treesAreTheSame(new TreeNode(1), new TreeNode(2)));

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.right.right.right = new TreeNode(10);

        assertTrue(treesAndGraphs.treesAreTheSame(tree, tree));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);
        tree2.right.right.right = new TreeNode(11);

        assertFalse(treesAndGraphs.treesAreTheSame(tree, tree2));

        // TODO Complete this case
//        TreeNode original = new TreeNode(1);
//        original.left = new TreeNode(2);
//        original.right = new TreeNode(3);
//
//        TreeNode inverted = new TreeNode(1);
//        inverted.left = new TreeNode(3);
//        inverted.right = new TreeNode(2);
//
//        assertTrue(treesAndGraphs.treesAreTheSame(original, inverted));
    }

    @Test
    void testPathSum() {
        TreesAndGraphs treesAndGraphs = new TreesAndGraphs();
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(-2);
        tree.left.right = new TreeNode(2);
        tree.left.right.right = new TreeNode(1);
        tree.right = new TreeNode(-3);
        tree.right.right = new TreeNode(11);

        assertEquals(3,treesAndGraphs.pathSum(tree, 8));// 3

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);

        assertEquals(1, treesAndGraphs.pathSum(tree2, 2));

        TreeNode tree3 = new TreeNode(0);
        tree3.left = new TreeNode(1);
        tree3.right = new TreeNode(1);

        assertEquals(4, treesAndGraphs.pathSum(tree3, 1));

        TreeNode tree4 = new TreeNode(1);

        assertEquals(0, treesAndGraphs.pathSum(tree4, 0));
    }
}
