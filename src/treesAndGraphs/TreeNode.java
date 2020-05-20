package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    static TreeNode createTree(int[] array) {
        if (array.length == 0) return null;
        int arrayIndex = 0;

        TreeNode node = null;
        TreeNode current = new TreeNode(array[arrayIndex]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            if (node == null) {
                node = queue.remove();
                arrayIndex++;
            }

            if (arrayIndex <= array.length - 1) {
                current.left = new TreeNode(array[arrayIndex]);
                arrayIndex++;
                queue.add(current.left);
            }

            if (arrayIndex <= array.length - 1) {
                current.right = new TreeNode(array[arrayIndex]);
                arrayIndex++;
                queue.add(current.right);
            }

            if (queue.size() > 0) {
                current = queue.remove();
            }
        }


        return node;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
