package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index = -1;

    public BSTIterator(TreeNode root) {
        if (root != null) {
            helper(root);
        }
    }

    private void helper(TreeNode node) {
        if (node != null) {
            helper(node.left);
            list.add(node.val);
            helper(node.right);
        }
    }

    public int next() {
        if (hasNext()) {
            return list.get(++index);
        }
        return -1;
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }
}