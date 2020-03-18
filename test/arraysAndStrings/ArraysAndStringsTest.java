package arraysAndStrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
