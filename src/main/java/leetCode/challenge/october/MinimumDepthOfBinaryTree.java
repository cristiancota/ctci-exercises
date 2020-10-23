package leetCode.challenge.october;

import treesAndGraphs.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return minDepth(root, 1, Integer.MAX_VALUE);
    }

    int minDepth(TreeNode node, int depth, int currentMin) {
        if (node == null) {
            return currentMin;
        }

        if (node.left == null && node.right == null) {
            currentMin = Math.min(depth, currentMin);
        }

        return Math.min(minDepth(node.left, depth + 1, currentMin), minDepth(node.right, depth + 1, currentMin));
    }
}
