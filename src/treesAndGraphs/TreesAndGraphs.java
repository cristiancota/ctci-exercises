package treesAndGraphs;

import java.util.*;

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

    int successor(TreeNode tree, int x) {
        return successor(tree, x, -1);
    }

    private int successor(TreeNode node, int x, int result) {
        if (node != null) {
            result = successor(node.left, x, result);

            if (result != -1) {
                if (result == Integer.MAX_VALUE)
                    return node.value;
                else
                    return result;
            }

            if (node.value == x)
                result = Integer.MAX_VALUE;

            result = successor(node.right, x, result);
        }
        return result;
    }

    String[] buildOrder(String[] projects, String[][] dependencies) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String project : projects) {
            map.put(project, Collections.emptyList());
        }

        for (String[] pair : dependencies) {
            String dependency = pair[0];
            String project = pair[1];
            ArrayList<String> strings = new ArrayList<>(map.get(project));
            strings.add(dependency);
            map.put(project, strings);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Queue<String> queue = new LinkedList<>(entry.getValue());
            List<String> finalDependencies = new ArrayList<>();
            while (!queue.isEmpty()) {
                String current = queue.remove();
                finalDependencies.add(current);
                List<String> strings = map.get(current);
                if (strings != null) {
                    queue.addAll(strings);
                }
            }

            map.put(entry.getKey(), finalDependencies);
        }

        LinkedHashSet<String> sorted = new LinkedHashSet<>();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(List::size)))
                .forEachOrdered(x -> sorted.add(x.getKey()));

        return sorted.toArray(new String[0]);
    }

    int findCommonAncestor(TreeNode tree, int a, int b) {
        return commonAncestorHelper(tree, a, b);
    }

    private int commonAncestorHelper(TreeNode node, int a, int b) {
        // TODO complete this.
        return -1;
    }

    List<Integer> getParents(TreeNode tree, int x) {
        return getParentsHelper(tree, x);
    }

    private List<Integer> getParentsHelper(TreeNode node, int x) {
        List<Integer> result = null;

        if (node != null) {
            result = getParentsHelper(node.left, x);

            if (node.value == x)
                return new ArrayList<>();

            result = getParentsHelper(node.right, x) == null ? result : getParentsHelper(node.right, x);

            if (result != null)
                result.add(node.value);
        }

        return result;
    }

    boolean treesAreTheSame(TreeNode a, TreeNode b) {
        return sameHelper(a, b);
    }

    private boolean sameHelper(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            if (a.value != b.value) return false;

            return sameHelper(a.left, b.left) && sameHelper(a.right, b.right);
        }

        if (a == null && b != null) return false;
        return a == null;
    }
}
