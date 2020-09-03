package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        return connectHelper(root);
    }

    private Node connectHelper(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }

        root.next = null;
        if (root.left != null) {
            queue.add(root.left);
        }

        if (root.right != null) {
            queue.add(root.right);
        }

        queue.add(null);

        while (!queue.isEmpty() && queue.peek() != null) {
            Node current = queue.remove();
            current.next = queue.peek();

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

            if (current.next == null) {
                queue.add(null);
                queue.remove();
            }
        }


        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
