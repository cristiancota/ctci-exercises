package leetCode;

import treesAndGraphs.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    TreeNode helper(TreeNode node) {
        if (node == null) return null;
        TreeNode aux = node.left;
        node.left = helper(node.right);
        node.right = helper(aux);

        return node;
    }
}
