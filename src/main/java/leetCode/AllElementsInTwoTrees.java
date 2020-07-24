package leetCode;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> integers = new ArrayList<>();
        populateList(root1, integers);
        populateList(root2, integers);
        Collections.sort(integers);
        return integers;
    }

    private void populateList(TreeNode node, List<Integer> integers) {
        if (node == null) return;
        populateList(node.left, integers);
        integers.add(node.val);
        populateList(node.right, integers);
    }
}
