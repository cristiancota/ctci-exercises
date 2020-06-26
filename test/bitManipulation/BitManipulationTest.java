package bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitManipulationTest {

    BitManipulation bitManipulation = new BitManipulation();

    @Test
    void testInsertion() {
        assertEquals(1100, bitManipulation.insertion(1024, 19, 2, 6));
        assertEquals(133, bitManipulation.insertion(128, 5, 0, 2));
        assertEquals(556, bitManipulation.insertion(512, 11, 2, 5));
        assertEquals(126, bitManipulation.insertion(64, 31, 1, 5));
        assertEquals(181, bitManipulation.insertion(173, 2, 3, 4));
    }

    @Test
    void testBinaryToString() {
        assertEquals(".101", bitManipulation.binaryToString(0.625));
        assertEquals(".1", bitManipulation.binaryToString(0.5));
        assertEquals(".010101", bitManipulation.binaryToString(0.328125));
        assertEquals(".11111111111111111111111111111111", bitManipulation.binaryToString(0.99999999976716935634613037109375));
        assertEquals("ERROR", bitManipulation.binaryToString(0.999999999883584678173065185546875));
        assertEquals("ERROR", bitManipulation.binaryToString(0.78));
        assertEquals("ERROR", bitManipulation.binaryToString(0.1));
        assertEquals("ERROR", bitManipulation.binaryToString(1));
        assertEquals("ERROR", bitManipulation.binaryToString(0));
        assertEquals("ERROR", bitManipulation.binaryToString(-1));
    }

    @Test
    void testFlipToWin() {
        assertEquals(8, bitManipulation.flipBitToWin(1775));
        assertEquals(4, bitManipulation.flipBitToWin(973));
        assertEquals(9, bitManipulation.flipBitToWin(16111));
        assertEquals(2, bitManipulation.flipBitToWin(5));
        assertEquals(2, bitManipulation.flipBitToWin(3));
    }

    @Test
    void testNextNumber() {
        assertArrayEquals(new int[]{9, 12}, bitManipulation.nextNumber(10));
        assertArrayEquals(new int[]{10, 20}, bitManipulation.nextNumber(12));
        assertArrayEquals(new int[]{21, 26}, bitManipulation.nextNumber(22));
        assertArrayEquals(new int[]{2147483647, 2147483647}, bitManipulation.nextNumber(2147483647));
        assertArrayEquals(new int[]{2147483645, 2147483646}, bitManipulation.nextNumber(2147483646));
    }

    @Test
    void testDebugger() {
        assertTrue(bitManipulation.debugger(1));
        assertTrue(bitManipulation.debugger(2));
        assertTrue(bitManipulation.debugger(4));
        assertTrue(bitManipulation.debugger(8));
        assertTrue(bitManipulation.debugger(16));
        assertTrue(bitManipulation.debugger(64));
        assertTrue(bitManipulation.debugger(256));
        assertTrue(bitManipulation.debugger(32768));
        assertTrue(bitManipulation.debugger(1048576));
        assertFalse(bitManipulation.debugger(1048575));
        assertFalse(bitManipulation.debugger(5));
        assertFalse(bitManipulation.debugger(50));
        assertFalse(bitManipulation.debugger(12345));
    }

    @Test
    void testConversion() {
        assertEquals(2, bitManipulation.conversion(29, 15));
        assertEquals(3, bitManipulation.conversion(83, 26));
        assertEquals(8, bitManipulation.conversion(511, 1));
        assertEquals(3, bitManipulation.conversion(170, 173));
        assertEquals(11, bitManipulation.conversion(1365, 682));
    }
}
