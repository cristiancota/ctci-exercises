package bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitManipulationTest {

    @Test
    void testInsertion() {
        final BitManipulation bitManipulation = new BitManipulation();
        assertEquals(1100, bitManipulation.insertion(1024, 19, 2, 6));
        assertEquals(133, bitManipulation.insertion(128, 5, 0, 2));
        assertEquals(556, bitManipulation.insertion(512, 11, 2, 5));
        assertEquals(126, bitManipulation.insertion(64, 31, 1, 6));
    }
}
