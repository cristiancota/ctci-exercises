package stackAndQueues;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StackAndQueuesTest {

    @Test
    public void testThreeInOne() {
        StackAndQueues stackAndQueues = new StackAndQueues();
        List<CStack> stacks = stackAndQueues.threeInOne(new int[]{1, 2, 3, 4, 5, 6, 7});
        CStack firstStack = stacks.get(0);
        assertFalse(firstStack.isEmpty());
        assertEquals(2, firstStack.pop());
        assertEquals(1, firstStack.pop());

        CStack secondStack = stacks.get(1);
        assertFalse(secondStack.isEmpty());
        assertEquals(4, secondStack.pop());
        assertEquals(3, secondStack.pop());

        CStack thirdStack = stacks.get(2);
        assertFalse(thirdStack.isEmpty());
        assertEquals(7, thirdStack.pop());
        assertEquals(6, thirdStack.pop());
        assertEquals(5, thirdStack.pop());
    }
}