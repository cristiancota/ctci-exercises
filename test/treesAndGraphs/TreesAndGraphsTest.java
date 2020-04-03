package treesAndGraphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(treesAndGraphs.routeBetweenNodes(node1, node2));
        assertFalse(treesAndGraphs.routeBetweenNodes(node4, node2));
        assertTrue(treesAndGraphs.routeBetweenNodes(node5, node4));
        assertTrue(treesAndGraphs.routeBetweenNodes(node3, node2));
    }
}
