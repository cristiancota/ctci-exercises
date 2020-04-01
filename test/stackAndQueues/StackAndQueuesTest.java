package stackAndQueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackAndQueuesTest {

    @Test
    public void testThreeInOne() {
        StackAndQueues stackAndQueues = new StackAndQueues();
        List<CStack<Integer>> stacks = stackAndQueues.threeInOne(new int[]{1, 2, 3, 4, 5, 6, 7});
        CStack<Integer> firstStack = stacks.get(0);
        assertFalse(firstStack.isEmpty());
        assertEquals(2, firstStack.pop());
        assertEquals(1, firstStack.pop());

        CStack<Integer> secondStack = stacks.get(1);
        assertFalse(secondStack.isEmpty());
        assertEquals(4, secondStack.pop());
        assertEquals(3, secondStack.pop());

        CStack<Integer> thirdStack = stacks.get(2);
        assertFalse(thirdStack.isEmpty());
        assertEquals(7, thirdStack.pop());
        assertEquals(6, thirdStack.pop());
        assertEquals(5, thirdStack.pop());
    }

    @Test
    public void testStackMin() {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(6);
        minStack.push(3);
        minStack.push(7);
        assertEquals(3, minStack.min());
        minStack.pop();
        assertEquals(3, minStack.min());
        minStack.pop();
        assertEquals(5, minStack.min());
    }

    @Test
    public void testSetOfStacks() {
        final int max_capacity = 3;
        SetOfStacks setOfStacks = new SetOfStacks(max_capacity);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        assertThrows(EmptyStackException.class, setOfStacks::pop);
    }
}