package leetCode;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>(Collections.emptyList());
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        ans.add(Collections.singletonList(root.val));
        int currentChildren = root.children.size();
        int nextChildren = 0;
        List<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current == null) {
                if (!currentList.isEmpty()) {
                    ans.add(currentList);
                }
                currentList = new ArrayList<>();
                continue;
            }
            for (int i = 0; i < current.children.size(); i++) {
                Node currentNode = current.children.get(i);
                currentList.add(currentNode.val);
                if (!currentNode.children.isEmpty()) {
                    queue.add(currentNode);
                }
                nextChildren += currentNode.children.size();
            }
            currentChildren -= current.children.size();
            if (currentChildren == 0) {
                queue.add(null);
                currentChildren = nextChildren;
                nextChildren = 0;
            }
        }
        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}