package stackAndQueues;

import java.util.ArrayList;
import java.util.List;

public class StackAndQueues {
    public List<CStack<Integer>> threeInOne(int[] array) {
        List<CStack<Integer>> result = new ArrayList<>(3);
        result.add(0, new CStack<>());
        result.add(1, new CStack<>());
        result.add(2, new CStack<>());

        int first, second;
        int size = array.length;
        if (size % 3 > 0) {
            first = size / 3;
            second = ((size - first) / 2) + first;
        } else {
            first = size / 3;
            second = first * 2;
        }

        for (int i = 0; i < size; i++) {
            if (i < first) {
                CStack<Integer> cStack = result.get(0);
                cStack.push(array[i]);
            } else if (i < second) {
                CStack<Integer> cStack = result.get(1);
                cStack.push(array[i]);
            } else {
                CStack<Integer> cStack = result.get(2);
                cStack.push(array[i]);
            }
        }

        return result;
    }

    public void sort(CStack<Integer> stack) {
        CStack<Integer> sortedStack = new CStack<>();
        CStack<Integer> buffer = new CStack<>();

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > pop) {
                buffer.push(sortedStack.pop()); // save in buffer bigger elements than the pop in the sorted stack
            }

            sortedStack.push(pop);
            while (!buffer.isEmpty()) {
                sortedStack.push(buffer.pop()); // return from buffer to sorted stack
            }
        }

        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }
}
