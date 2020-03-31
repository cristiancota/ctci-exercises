package stackAndQueues;

import java.util.EmptyStackException;

public class SetOfStacks extends CStack<Integer> {
    private CStack<CStack<Integer>> set;
    private int MAX_CAPACITY;
    private int currentCapacity;

    public SetOfStacks(int MAX_CAPACITY) {
        set = new CStack<>();
        currentCapacity = MAX_CAPACITY;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void push(int item) {
        if (set.isEmpty() || currentCapacity == 0) {
            CStack<Integer> newStack = new CStack<>();
            newStack.push(item);
            set.push(newStack);
        } else {
            CStack<Integer> currentStack = set.pop();
            currentStack.push(item);
            set.push(currentStack);
        }
        currentCapacity--;
    }

    public Integer pop() {
        if (set.isEmpty()) {
            throw new EmptyStackException();
        } else {
            CStack<Integer> currentStack = set.pop();
            if (currentCapacity == MAX_CAPACITY - 1) {
                currentCapacity = 0;
            } else {
                currentCapacity++;
            }
            Integer item = currentStack.pop();

            if (!currentStack.isEmpty()) {
                set.push(currentStack);
            }

            return item;
        }
    }
}
