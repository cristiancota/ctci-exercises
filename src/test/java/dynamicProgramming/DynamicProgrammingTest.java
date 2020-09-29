package dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        assertEquals(1, dynamicProgramming.tripleStep(0)); // there's no right answer for this, due my approach I need this to be 1
        assertEquals(1, dynamicProgramming.tripleStep(1));
        assertEquals(2, dynamicProgramming.tripleStep(2));
        assertEquals(4, dynamicProgramming.tripleStep(3));
        assertEquals(7, dynamicProgramming.tripleStep(4));
        assertEquals(13, dynamicProgramming.tripleStep(5));
        assertEquals(24, dynamicProgramming.tripleStep(6));
    }

    @Test
    void testRobotInGrid() {
        // 1 1 1
        // 1 1 0
        // 1 1 1
        List<Coordinate> expected = new ArrayList<>();
        expected.add(new Coordinate(0, 0));
        expected.add(new Coordinate(0, 1));
        expected.add(new Coordinate(1, 1));
        expected.add(new Coordinate(2, 1));
        expected.add(new Coordinate(2, 2));
        assertArrayEquals(expected.toArray(), dynamicProgramming.robotInAGrid(new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 1, 1}
        }).toArray());

        // 1 0 1
        // 1 0 1
        // 1 1 1
        expected = new ArrayList<>();
        expected.add(new Coordinate(0, 0));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(2, 0));
        expected.add(new Coordinate(2, 1));
        expected.add(new Coordinate(2, 2));
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
        expected.add(new Coordinate(0, 0));
        expected.add(new Coordinate(1, 0));
        expected.add(new Coordinate(2, 0));
        expected.add(new Coordinate(3, 0));
        expected.add(new Coordinate(4, 0));
        expected.add(new Coordinate(4, 1));
        expected.add(new Coordinate(4, 2));
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

    @Test
    void testMagicNumber() {
        assertEquals(0, dynamicProgramming.magicIndex(new int[]{0, 8, 40, 43, 50}));
        assertEquals(3, dynamicProgramming.magicIndex(new int[]{-5, -2, 1, 3, 6, 12, 5000}));
        assertEquals(5, dynamicProgramming.magicIndex(new int[]{-8, -7, -4, 0, 1, 5}));
        assertEquals(-1, dynamicProgramming.magicIndex(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(-1, dynamicProgramming.magicIndex(new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1}));
        assertEquals(-1, dynamicProgramming.magicIndex(new int[]{}));

        assertEquals(0, dynamicProgramming.magicIndexBinary(new int[]{0, 8, 40, 43, 50}));
        assertEquals(3, dynamicProgramming.magicIndexBinary(new int[]{-5, -2, 1, 3, 6, 12, 5000}));
        assertEquals(5, dynamicProgramming.magicIndexBinary(new int[]{-8, -7, -4, 0, 1, 5}));
        assertEquals(-1, dynamicProgramming.magicIndexBinary(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals(-1, dynamicProgramming.magicIndexBinary(new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1}));
        assertEquals(-1, dynamicProgramming.magicIndexBinary(new int[]{}));
    }

    @Test
    void testPowerSet() {
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Collections.singletonList(1));
        expected.add(Collections.singletonList(2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Collections.singletonList(3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(1, 2, 3));

        assertEquals(expected, dynamicProgramming.powerSet(new int[]{1, 2, 3}));

        expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(Collections.singletonList(1));
        expected.add(Collections.singletonList(2));
        expected.add(Arrays.asList(1, 2));

        assertEquals(expected, dynamicProgramming.powerSet(new int[]{1, 2}));
    }

    @Test
    void testRecursiveMultiply() {
        assertEquals(2, dynamicProgramming.recursiveMultiply(1, 2));
        assertEquals(49, dynamicProgramming.recursiveMultiply(7, 7));
        assertEquals(1472, dynamicProgramming.recursiveMultiply(23, 64));
        assertEquals(0, dynamicProgramming.recursiveMultiply(7, 0));
        assertEquals(0, dynamicProgramming.recursiveMultiply(0, 7));
    }
}