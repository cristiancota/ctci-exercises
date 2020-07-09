package leetCode;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getLevels(root, list, 0);
        return list;
    }

    void getLevels(TreeNode node, List<Integer> list, int level) {
        if (node != null) {
            if (list.size() == level) {
                list.add(node.val);
            }
            getLevels(node.right, list, level + 1);
            getLevels(node.left, list, level + 1);
        }
    }
}
