package leetCode.challenge.october;

import treesAndGraphs.TreeNode;

public class MinimunDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return minDepth(root, 1, Integer.MAX_VALUE);
    }

    int minDepth(TreeNode node, int depth, int currentMin) {
        if (node == null) {
            return currentMin;
        }

        if (isLeaf(node)) {
            currentMin = Math.min(depth, currentMin);
        }

        return Math.min(minDepth(node.left, depth + 1, currentMin), minDepth(node.right, depth + 1, currentMin));
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
