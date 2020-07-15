package leetCode;

import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    SortedSet<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new TreeSet<>();
    }

    public void push(int x) {
        min.add(x);
        stack.push(x);
    }

    public void pop() {
        Integer peek = stack.peek();
        stack.pop();
        if (peek.equals(min.first()) && !stack.contains(peek)) {
            min.remove(peek);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.first();
    }
}