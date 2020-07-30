package leetCode;

import treesAndGraphs.TreeNode;

public class SumRootToLeafNumbers {
    int sumNumbers(TreeNode tree) {
        if (tree == null) return 0;
        return sumNumberHelper(tree, 0);
    }

    private int sumNumberHelper(TreeNode node, int val) {
        if (node != null) {
            if (isLeaf(node)) {
                return (val * 10) + node.val;
            } else {
                val *= 10;
                return sumNumberHelper(node.left, val + node.val) + sumNumberHelper(node.right, val + node.val);
            }
        }
        return 0;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
