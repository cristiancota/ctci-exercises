package leetCode;

import treesAndGraphs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if (isLeaf(root)) {
            return root.val;
        }

        Map<Integer, Integer> map = new HashMap<>();
        helper(root, 1, map);

        return map.get(map.size());
    }

    private void helper(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node != null) {
            map.putIfAbsent(level, 0);
            Integer integer = map.get(level);
            map.put(level, integer + node.val);
            helper(node.left, level + 1, map);
            helper(node.right, level + 1, map);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}