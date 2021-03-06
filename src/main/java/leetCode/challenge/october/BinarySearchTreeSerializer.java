package leetCode.challenge.october;

import treesAndGraphs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeSerializer {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder builder = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current == null) {
                builder.append("null,");
                continue;
            }

            builder.append(current.val);
            builder.append(",");

            if (current.left == null && current.right == null && queue.isEmpty()) {
                continue;
            }

            queue.add(current.left);
            queue.add(current.right);
        }

        return builder.substring(0, builder.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        String[] split = data.split(",");

        Queue<TreeNode> nodes = new LinkedList<>();

        for (String s : split) {
            if (s.equals("null")) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.parseInt(s)));
            }
        }

        if (nodes.isEmpty()) {
            return null;
        }

        TreeNode result = nodes.remove();

        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(result);

        while (!nodes.isEmpty()) {
            TreeNode currentParent = parents.remove();
            if (currentParent == null) {
                continue;
            }

            TreeNode leftNode = nodes.remove();
            currentParent.left = leftNode;
            parents.add(leftNode);

            TreeNode rightNode = nodes.remove();
            currentParent.right = rightNode;
            parents.add(rightNode);
        }

        return result;
    }
}
