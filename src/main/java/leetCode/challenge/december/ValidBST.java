package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

public class ValidBST {
    public boolean isValidBST(TreeNode node) {
        return helper(node, null, null);
    }
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;

        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!helper(node.left, lower, val)) return false;
        return helper(node.right, val, upper);
    }
}
