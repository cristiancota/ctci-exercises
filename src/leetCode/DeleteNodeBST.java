package leetCode;

import treesAndGraphs.TreeNode;

public class DeleteNodeBST {
    TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }

    private TreeNode helper(TreeNode node, int key) {
        if (node != null) {
            if (node.val == key) {
                if (node.right == null) {
                    return node.left;
                }

                if (node.left == null) {
                    return node.right;
                }

                TreeNode aux = node.right;
                while (aux.left != null) {
                    aux = aux.left;
                }

                node.val = aux.val;
                node.right = helper(node.right, node.val);
            } else if (node.val > key) {
                node.left = helper(node.left, key);
            } else {
                node.right = helper(node.right, key);
            }

            return node;
        }
        return null;
    }
}
