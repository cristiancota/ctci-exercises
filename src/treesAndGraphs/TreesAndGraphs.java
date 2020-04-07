package treesAndGraphs;

import java.util.HashSet;

class TreesAndGraphs {

    void inOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.left);
            visitNode(treeNode);
            inOrderTraversal(treeNode.right);
        }
    }

    void preOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            visitNode(treeNode);
            preOrderTraversal(treeNode.left);
            preOrderTraversal(treeNode.right);
        }
    }

    void postOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            postOrderTraversal(treeNode.left);
            postOrderTraversal(treeNode.right);
            visitNode(treeNode);
        }
    }

    void visitNode(TreeNode treeNode) {
        System.out.println(treeNode.value);
    }

    boolean isRouteBetweenNodes(GraphNode n1, GraphNode n2) {
        HashSet<Integer> visited = new HashSet<>();
        return doSearch(n1, n2, visited);
    }

    private boolean doSearch(GraphNode n1, GraphNode n2, HashSet<Integer> visited) {
        if (visited.contains(n1.id)) {
            return false;
        }

        if (n1.id == n2.id) {
            return true;
        }

        visited.add(n1.id);

        for (GraphNode adj : n1.adjacent) {
            if (doSearch(adj, n2, visited)) {
                return true;
            }
        }

        return false;
    }

}
