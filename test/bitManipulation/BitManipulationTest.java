package bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitManipulationTest {

    final BitManipulation bitManipulation = new BitManipulation();

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
}
