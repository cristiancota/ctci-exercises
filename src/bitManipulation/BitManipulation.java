package bitManipulation;

public class BitManipulation {
    int insertion(int n, int m, int i, int j) {
        for (int index = i; index <= j; index++) {
            int current = m % 2 == 0 ? 0 : 1;
            n |= (current << index);
            m >>= 1;
        }

        return n;
    }
}
