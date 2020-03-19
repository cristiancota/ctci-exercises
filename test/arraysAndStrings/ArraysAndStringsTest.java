package arraysAndStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {

    @Test
    void testIsUnique() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.isUnique("abcde"));
        assertFalse(arraysAndStrings.isUnique("abcda"));
    }

    @Test
    void testArePermutation() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.arePermutation("abc", "bca"));
        assertTrue(arraysAndStrings.arePermutation("", ""));
        assertTrue(arraysAndStrings.arePermutation("aaa", "aaa"));
        assertFalse(arraysAndStrings.arePermutation("aaa", "aab"));
        assertFalse(arraysAndStrings.arePermutation("a", "b"));
        assertFalse(arraysAndStrings.arePermutation("a", "aa"));
    }

    @Test
    void testURLify() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertEquals("Mr%20John%20Smith", arraysAndStrings.urlify("Mr John Smith     ", 13));
        assertEquals("cristian%20cota", arraysAndStrings.urlify("cristian cota", 13));
        assertEquals("a%20b%20c%20d", arraysAndStrings.urlify("a b c d", 7));
    }

    @Test
    void testPalindromePermutation() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.isPalindromePermutation("Tact coa"));
        assertTrue(arraysAndStrings.isPalindromePermutation("anita lava la tina"));
        assertTrue(arraysAndStrings.isPalindromePermutation("aabbaa"));
        assertTrue(arraysAndStrings.isPalindromePermutation("a ab baa"));
        assertFalse(arraysAndStrings.isPalindromePermutation("this is not a palindrome at all x"));
    }

    @Test
    void testIsOneAway() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.isOneAway("ala", "pala"));
        assertTrue(arraysAndStrings.isOneAway("pale", "ple"));
        assertTrue(arraysAndStrings.isOneAway("pales", "pale"));
        assertTrue(arraysAndStrings.isOneAway("pale", "bale"));
        assertTrue(arraysAndStrings.isOneAway("bake", "bake"));
        assertFalse(arraysAndStrings.isOneAway("pale", "bake"));
    }

    @Test
    void testStringCompression() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertEquals("a4b3", arraysAndStrings.stringCompression("aaaabbb"));
        assertEquals("abcd", arraysAndStrings.stringCompression("abcd"));
        assertEquals("a2b1c5a3", arraysAndStrings.stringCompression("aabcccccaaa"));
        assertEquals("A1a2b1c5a3", arraysAndStrings.stringCompression("Aaabcccccaaa"));
    }

    @Test
    void testRotateMatrix() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        int[][] matrix = new int[][]{
                {10, 20},
                {30, 40}
        };
        assertArrayEquals(new int[][]{
                {30, 10},
                {40, 20}
        }, arraysAndStrings.rotateMatrix(matrix));

        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertArrayEquals(new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        }, arraysAndStrings.rotateMatrix(matrix));

        matrix = new int[][]{
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };
        assertArrayEquals(new int[][]{
                {4, 33, 13, 32, 12, 2},
                {24, 1, 14, 33, 27, 29},
                {1, 20, 32, 32, 9, 20},
                {6, 7, 27, 2, 25, 26},
                {32, 21, 22, 28, 13, 16},
                {34, 7, 26, 14, 21, 28}
        }, arraysAndStrings.rotateMatrix(matrix));
    }

    @Test
    void testZeroMatrix() {
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        int[][] matrix = new int[][]{
                {10, 0},
                {30, 40}
        };
        assertArrayEquals(new int[][]{
                {0, 0},
                {30, 0}
        }, arraysAndStrings.zeroMatrix(matrix));

        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        assertArrayEquals(new int[][]{
                {1, 0, 3},
                {4, 0, 6},
                {0, 0, 0}
        }, arraysAndStrings.zeroMatrix(matrix));

        matrix = new int[][]{
                {2, 29, 20, 26, 16, 28},
                {12, 0, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };
        assertArrayEquals(new int[][]{
                {2, 0, 20, 26, 16, 28},
                {0, 0, 0, 0, 0, 0},
                {32, 0, 32, 2, 28, 14},
                {13, 0, 32, 27, 22, 26},
                {33, 0, 20, 7, 21, 7},
                {4, 0, 1, 6, 32, 34}
        }, arraysAndStrings.zeroMatrix(matrix));
    }

    @Test
    void testStringRotation(){
        ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
        assertTrue(arraysAndStrings.stringRotation("abcde", "cdeab"));
        assertTrue(arraysAndStrings.stringRotation("aaaabcd", "aabcdaa"));
        assertTrue(arraysAndStrings.stringRotation("cristian","ristianc"));
        assertTrue(arraysAndStrings.stringRotation("bbbacddceeb","ceebbbbacdd"));
        assertFalse(arraysAndStrings.stringRotation("abcde","abced"));
    }
}
