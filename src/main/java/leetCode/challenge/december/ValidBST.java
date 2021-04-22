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

    TreeNode prev;

    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }

        // inorder => left -> root -> right
        if (!isValidBST2(node.left)) {
            return false;
        }

        if (prev != null) {
            // if prev is greater or equal than current is invalid BST
            if (prev.val >= node.val) {
                return false;
            }
        }

        prev = node;

        return isValidBST2(node.right);
    }
}
