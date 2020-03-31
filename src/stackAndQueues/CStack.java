package stackAndQueues;

import java.util.EmptyStackException;

public class CStack<T> {
    class StackNode {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode newStackNode = new StackNode(item);
        newStackNode.next = top;
        top = newStackNode;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}