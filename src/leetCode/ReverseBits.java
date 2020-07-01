package leetCode;

public class ReverseBits {
    public int reverseBits(int n) {
        int integerResult = 0;
        for (int i = 0; i < 32; i++) {
            integerResult <<= 1; // left shift every time we enter the loop, will be override if is odd
            if (n != 0) {
                if ((n & 1) != 0) {
                    integerResult++; // add 1 when n is odd number
                }
                n >>= 1;
            }
        }
        return integerResult;
    }
}