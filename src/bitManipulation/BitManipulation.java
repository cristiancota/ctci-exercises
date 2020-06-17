package bitManipulation;

public class BitManipulation {
    int insertion(int n, int m, int i, int j) {
        for (int index = i; index <= j; index++) {
            int current = m % 2 == 0 ? 0 : 1;
            n &= ~(1 << index); // clear bit
            n |= (current << index); // set bit
            m >>= 1; // right shift to m
        }

        return n;
    }
}
