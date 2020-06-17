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

    String binaryToString(double number) {
        if (number <= 0 || number >= 1) {
            return "ERROR";
        }

        StringBuilder ans = new StringBuilder(".");

        while (number > 0) {
            number *= 2;
            if (number >= 1) {
                ans.append(1);
                number -= 1;
            } else {
                ans.append(0);
            }

            if (ans.length() > 33) {
                return "ERROR";
            }
        }

        return ans.toString();
    }
}
