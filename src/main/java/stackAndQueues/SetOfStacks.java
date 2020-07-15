package stackAndQueues;

import java.util.EmptyStackException;
import java.util.HashMap;

public class SetOfStacks extends CStack<Integer> {
    private HashMap<Integer, CStack<Integer>> map;
    private int MAX_CAPACITY;
    private int currentCapacity;
    private int mapIndex;

    public SetOfStacks(int MAX_CAPACITY) {
        map = new HashMap<>();
        mapIndex = 0;
        currentCapacity = MAX_CAPACITY;
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public void push(int item) {
        if (map.isEmpty() || currentCapacity == 0) {
            CStack<Integer> newStack = new CStack<>();
            newStack.push(item);
            map.put(mapIndex, newStack);

            mapIndex++;
            currentCapacity = MAX_CAPACITY;
        } else {
            CStack<Integer> currentStack = map.get(mapIndex - 1);
            currentStack.push(item);
        }
        currentCapacity--;
    }

    public Integer pop() {
        if (map.isEmpty()) {
            throw new EmptyStackException();
        } else {
            CStack<Integer> currentStack = map.get(mapIndex - 1);
            if (currentCapacity == MAX_CAPACITY - 1) {
                currentCapacity = 0;
                map.remove(mapIndex - 1);
                mapIndex--;
            } else {
                currentCapacity++;
            }

            return currentStack.pop();
        }
    }

    public Integer popAt(int index) { // TODO follow up
        return null;
    }
}
