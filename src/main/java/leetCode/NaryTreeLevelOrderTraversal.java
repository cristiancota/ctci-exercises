package leetCode;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        if (root == null) {
            return new ArrayList<>(Collections.emptyList());
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<NaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        ans.add(Collections.singletonList(root.val));
        int currentChildren = root.children.size();
        int nextChildren = 0;
        List<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()) {
            NaryTreeNode current = queue.remove();
            if (current == null) {
                if (!currentList.isEmpty()) {
                    ans.add(currentList);
                }
                currentList = new ArrayList<>();
                continue;
            }
            for (int i = 0; i < current.children.size(); i++) {
                NaryTreeNode currentNode = current.children.get(i);
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
