package dynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicProgrammingTest {

    DynamicProgramming dynamicProgramming = new DynamicProgramming();

    @Test
    void testFibonacciMemo() {
        assertEquals(0, dynamicProgramming.fibonacciMemo(0));
        assertEquals(1, dynamicProgramming.fibonacciMemo(1));
        assertEquals(5, dynamicProgramming.fibonacciMemo(5));
        assertEquals(55, dynamicProgramming.fibonacciMemo(10));
        assertEquals(6765, dynamicProgramming.fibonacciMemo(20));
        assertEquals(832040, dynamicProgramming.fibonacciMemo(30));
        assertEquals(102334155, dynamicProgramming.fibonacciMemo(40));
//        assertEquals(1134903170, dynamicProgramming.fibonacciMemo(45)); // too slow
    }

    @Test
    void testFibonacciMemoBottomUpImproved() {
        assertEquals(0, dynamicProgramming.fibonacciMemoBottomUpImproved(0));
        assertEquals(1, dynamicProgramming.fibonacciMemoBottomUpImproved(1));
        assertEquals(5, dynamicProgramming.fibonacciMemoBottomUpImproved(5));
        assertEquals(55, dynamicProgramming.fibonacciMemoBottomUpImproved(10));
        assertEquals(832040, dynamicProgramming.fibonacciMemoBottomUpImproved(30));
        assertEquals(102334155, dynamicProgramming.fibonacciMemoBottomUpImproved(40));
        assertEquals(1134903170, dynamicProgramming.fibonacciMemoBottomUpImproved(45));
        assertEquals(12586269025L, dynamicProgramming.fibonacciMemoBottomUpImproved(50));
        assertEquals(3736710778780434371L, dynamicProgramming.fibonacciMemoBottomUpImproved(100));
    }

    @Test
    void testTripleStep() {
        assertEquals(1, dynamicProgramming.tripleStep(0));
        assertEquals(1, dynamicProgramming.tripleStep(1));
        assertEquals(2, dynamicProgramming.tripleStep(2));
        assertEquals(4, dynamicProgramming.tripleStep(3));
        assertEquals(7, dynamicProgramming.tripleStep(4));
        assertEquals(13, dynamicProgramming.tripleStep(5));
    }
}