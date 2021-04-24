package leetCode;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postOrderTraversal(node.left, list);
            postOrderTraversal(node.right, list);
            list.add(node.val);
        }
    }
}
