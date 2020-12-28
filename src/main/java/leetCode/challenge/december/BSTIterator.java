package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class BSTIterator {
    Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        if (root != null) {
            fillQueue(root);
        }
    }

    private void fillQueue(TreeNode node) {
        if (node != null) {
            fillQueue(node.left);
            queue.add(node.val);
            fillQueue(node.right);
        }
    }

    public int next() {
        if (hasNext()) {
            return queue.remove();
        }
        return -1;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}