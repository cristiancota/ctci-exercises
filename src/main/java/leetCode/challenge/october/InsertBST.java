package leetCode.challenge.october;

import treesAndGraphs.TreeNode;

public class InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            if (root.left == null) {
                root.left = insertIntoBST(null, val);
            } else {
                insertIntoBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = insertIntoBST(null, val);
            } else {
                insertIntoBST(root.right, val);
            }
        }

        return root;
    }

}
