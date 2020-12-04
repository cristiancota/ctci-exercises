package leetCode.challenge.december;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode ans = new TreeNode(list.get(0));
        TreeNode current = ans;

        for (int i = 1; i < list.size(); i++) {
            current.right = new TreeNode(list.get(i));
            current = current.right;
        }

        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
