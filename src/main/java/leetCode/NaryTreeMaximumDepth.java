package leetCode;

public class NaryTreeMaximumDepth {
    public int maxDepth(NaryTreeNode root) {
        return maxDepth(root, 1, 0);
    }

    public int maxDepth(NaryTreeNode root, int current, int max) {
        if (root != null) {
            for (int i = 0; i < root.children.size(); i++) {
                NaryTreeNode node = root.children.get(i);
                max = maxDepth(node, current + 1, max);
            }
            return Math.max(current, max);

        }
        return max;
    }
}
