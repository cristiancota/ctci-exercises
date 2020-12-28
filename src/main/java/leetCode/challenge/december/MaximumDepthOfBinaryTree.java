package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int max) {
        if (node != null) {
            max++;
            if (node.left == null && node.right == null) {
                return max;
            } else {
                return Math.max(maxDepth(node.left, max), maxDepth(node.right, max));
            }
        }

        return max;
    }
}
