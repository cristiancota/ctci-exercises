package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int max) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                return max;
            } else {
                return Math.max(maxDepth(node.left, max + 1), maxDepth(node.right, max + 1));
            }
        }

        return max;
    }
}
