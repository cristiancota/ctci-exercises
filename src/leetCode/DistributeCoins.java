package leetCode;

import treesAndGraphs.TreeNode;

public class DistributeCoins {
    public int distributeCoins(TreeNode root) {
        Result result = new Result();
        helper(root, result);
        return result.moves;
    }

    int helper(TreeNode node, Result result) {
        if (node == null) return 0;
        int leftCount = helper(node.left, result);
        int rightCount = helper(node.right, result);
        result.moves += Math.abs(leftCount) + Math.abs(rightCount);
        return node.val + leftCount + rightCount - 1;
    }
}

class Result {
    int moves = 0;
}