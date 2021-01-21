package leetCode;

import treesAndGraphs.TreeNode;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }

    public TreeNode helper(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        n1.left = helper(n1.left, n2.left);
        n1.val = n1.val + n2.val;
        n1.right = helper(n1.right, n2.right);

        return n1;
    }
}
