package leetCode;

import treesAndGraphs.TreeNode;

class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }

    private boolean helper(TreeNode node) {
        if (node == null) return true;

        boolean leftContainsZeroOnly = helper(node.left);
        boolean rightContainsZeroOnly = helper(node.right);

        if (leftContainsZeroOnly) {
            node.left = null;
        }

        if (rightContainsZeroOnly) {
            node.right = null;
        }

        return leftContainsZeroOnly && rightContainsZeroOnly && node.val == 0;
    }
}
