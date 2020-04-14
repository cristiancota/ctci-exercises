package treesAndGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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

    TreeNode minimalTree(int[] nums) {
        return buildMinimalTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildMinimalTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node;

        node = new TreeNode(nums[mid]);
        node.left = buildMinimalTree(nums, start, mid - 1);
        node.right = buildMinimalTree(nums, mid + 1, end);

        return node;
    }

    List<LinkedList<Integer>> listOfDepths(TreeNode tree) {
        List<LinkedList<Integer>> list = new ArrayList<>();
        if (tree != null)
            listOfDepths(0, list, tree);

        return list;
    }

    private void listOfDepths(int index, List<LinkedList<Integer>> list, TreeNode node) {
        if (node != null) {
            if (index >= list.size())
                list.add(new LinkedList<>());

            list.get(index).add(node.value);
            listOfDepths(index + 1, list, node.left);
            listOfDepths(index + 1, list, node.right);
        }
    }

    boolean isBalanced(TreeNode tree) {
        int leftDepth = getDepth(tree.left);
        int rightDepth = getDepth(tree.right);

        return Math.abs(leftDepth - rightDepth) < 2;
    }

    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    boolean validateBST(TreeNode tree) {
        return isBST(tree, null, null);
    }

    private boolean isBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.value;

        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!isBST(node.left, lower, val)) return false;
        return isBST(node.right, val, upper);
    }
}
