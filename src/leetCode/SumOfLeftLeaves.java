package leetCode;

import treesAndGraphs.TreeNode;

class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        if (isLeaf(root.left)) {
            sum += root.left.val;
        }

        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
