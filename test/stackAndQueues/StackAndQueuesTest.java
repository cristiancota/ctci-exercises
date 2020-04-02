package stackAndQueues;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testQueueViaStack() {
        QueueViaStack queue = new QueueViaStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.remove());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());

        assertTrue(queue.isEmpty());

        assertThrows(RuntimeException.class, queue::remove);
        assertThrows(RuntimeException.class, queue::peek);
    }

    @Test
    public void testSort() {
        StackAndQueues stackAndQueues = new StackAndQueues();
        CStack<Integer> cStack = new CStack<>();
        cStack.push(43);
        cStack.push(9);
        cStack.push(27);
        cStack.push(0);
        cStack.push(3);
        cStack.push(15);
        cStack.push(1580);

        assertEquals(1580, cStack.peek());

        stackAndQueues.sort(cStack);

        assertEquals(0, cStack.pop());
        assertEquals(3, cStack.pop());
        assertEquals(9, cStack.pop());
        assertEquals(15, cStack.pop());
        assertEquals(27, cStack.pop());
        assertEquals(43, cStack.pop());
        assertEquals(1580, cStack.pop());
    }

    @Test
    public void testAnimalShelter() {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("dog 1"));
        animalShelter.enqueue(new Dog("dog 2"));
        animalShelter.enqueue(new Cat("cat 1"));
        animalShelter.enqueue(new Dog("dog 3"));

        assertEquals("dog 1", animalShelter.dequeueAny().getName());
        assertEquals("cat 1", animalShelter.dequeueCat().getName());
        assertEquals("dog 2", animalShelter.dequeueDog().getName());
        assertNull(animalShelter.dequeueCat());
        assertEquals("dog 3", animalShelter.dequeueAny().getName());
    }
}