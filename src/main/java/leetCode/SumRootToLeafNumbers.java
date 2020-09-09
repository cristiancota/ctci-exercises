package leetCode;

import treesAndGraphs.TreeNode;

public class SumRootToLeafNumbers {
    int sumNumbers(TreeNode tree) {
        return sumNumberHelper(tree, 0);
    }

    private int sumNumberHelper(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) { // is leaf
            return (val * 10) + node.val;
        } else {
            val *= 10;
            return sumNumberHelper(node.left, val + node.val) + sumNumberHelper(node.right, val + node.val);
        }
    }
}
