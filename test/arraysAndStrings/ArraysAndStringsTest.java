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
        assertEquals(arraysAndStrings.urlify("Mr John Smith     ", 13), "Mr%20John%20Smith");
        assertEquals(arraysAndStrings.urlify("cristian cota", 13), "cristian%20cota");
    }
}
