package leetCode;

import treesAndGraphs.TreeNode;

public class DistributeCoins {
    public int distributeCoins(TreeNode root) {
        int [] result = new int [2];
        helper(root, result);
        return result[1];
    }

    int helper(TreeNode node, int [] result) {
        if (node == null) return result[0];
        int leftCount = helper(node.left, result);
        int rightCount = helper(node.right, result);
        result[1] += Math.abs(leftCount) + Math.abs(rightCount);
        return node.val + leftCount + rightCount - 1;
    }
}