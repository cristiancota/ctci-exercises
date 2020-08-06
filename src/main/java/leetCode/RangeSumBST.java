package leetCode;

import treesAndGraphs.TreeNode;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return rangeSumHelper(root, L, R, 0);
    }
    private int rangeSumHelper(TreeNode root, int L, int R, int ans) {
        if (root == null) { return 0; }
        if (root.val >= L && root.val <= R) { ans = root.val; }
        ans += rangeSumBST(root.left, L, R);
        ans += rangeSumBST(root.right, L, R);
        return ans;
    }
}