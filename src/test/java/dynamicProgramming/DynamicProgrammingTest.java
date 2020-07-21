package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testRobotInGrid() {
        // 1 1 1
        // 1 1 0
        // 1 1 1
        List<DynamicProgramming.Coordinate> expected = new ArrayList<>();
        expected.add(new DynamicProgramming.Coordinate(0, 0));
        expected.add(new DynamicProgramming.Coordinate(0, 1));
        expected.add(new DynamicProgramming.Coordinate(1, 1));
        expected.add(new DynamicProgramming.Coordinate(2, 1));
        expected.add(new DynamicProgramming.Coordinate(2, 2));
        assertArrayEquals(expected.toArray(), dynamicProgramming.robotInAGrid(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1}
        }).toArray());

        // 1 0 1
        // 1 0 1
        // 1 1 1
        expected = new ArrayList<>();
        expected.add(new DynamicProgramming.Coordinate(0, 0));
        expected.add(new DynamicProgramming.Coordinate(1, 0));
        expected.add(new DynamicProgramming.Coordinate(2, 0));
        expected.add(new DynamicProgramming.Coordinate(2, 1));
        expected.add(new DynamicProgramming.Coordinate(2, 2));
        assertArrayEquals(expected.toArray(), dynamicProgramming.robotInAGrid(new int[][]{
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}
        }).toArray());

        // 1 0 1
        // 1 1 0
        // 1 1 0
        // 1 0 0
        // 1 1 1
        expected = new ArrayList<>();
        expected.add(new DynamicProgramming.Coordinate(0, 0));
        expected.add(new DynamicProgramming.Coordinate(1, 0));
        expected.add(new DynamicProgramming.Coordinate(2, 0));
        expected.add(new DynamicProgramming.Coordinate(3, 0));
        expected.add(new DynamicProgramming.Coordinate(4, 0));
        expected.add(new DynamicProgramming.Coordinate(4, 1));
        expected.add(new DynamicProgramming.Coordinate(4, 2));
        assertArrayEquals(expected.toArray(), dynamicProgramming.robotInAGrid(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 1}
        }).toArray());

        // 1 0 1
        // 1 1 0
        assertTrue(dynamicProgramming.robotInAGrid(new int[][]{
                {1, 0, 1},
                {1, 1, 0}
        }).isEmpty());

        // 1 0 1
        // 1 1 0
        // 1 0 1
        assertTrue(dynamicProgramming.robotInAGrid(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 1}
        }).isEmpty());
    }
}