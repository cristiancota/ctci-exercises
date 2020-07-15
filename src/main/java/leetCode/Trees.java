package leetCode;

import treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {

    boolean isLeafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> aLeafs = getLeafs(root1, new ArrayList<>());
        List<Integer> bLeafs = getLeafs(root2, new ArrayList<>());

        if (aLeafs.size() != bLeafs.size()) return false;

        for (int i = 0; i < aLeafs.size(); i++) {
            if (!aLeafs.get(i).equals(bLeafs.get(i))) return false;
        }

        return true;
    }

    private List<Integer> getLeafs(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            } else {
                getLeafs(node.left, list);
                getLeafs(node.right, list);
            }
        }

        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversalHelper(root, new ArrayList<>());
    }

    List<Integer> preorderTraversalHelper(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorderTraversalHelper(node.left, list);
            preorderTraversalHelper(node.right, list);
        }
        return list;
    }

    // incomplete: https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/
    public List<Integer> iterativePreorderTraversal(TreeNode root) {
        Queue<TreeNode> lQueue = new LinkedList<>();
        Queue<TreeNode> rQueue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) lQueue.add(root);

        while (!lQueue.isEmpty() || !rQueue.isEmpty()) {
            TreeNode current = lQueue.isEmpty() ? rQueue.remove() : lQueue.remove();
            if (current.left != null)
                lQueue.add(current.left);

            if (current.right != null) {
                if (!lQueue.isEmpty()) {
                    if (!rQueue.isEmpty()) {
                        TreeNode remove = rQueue.remove();
                        rQueue.add(current.right);
                        rQueue.add(remove);
                    } else {
                        rQueue.add(current.right);
                    }
                } else {
                    rQueue.add(current.right);
                }
            }

            result.add(current.val);
        }

        return result;
    }
}
