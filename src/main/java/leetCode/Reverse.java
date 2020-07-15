package leetCode;

public class Reverse {
    public int reverse(int x) {
        long result = 0;
        long multiplier = 1;
        boolean isNegative = x < 0;

        x = isNegative ? x * -1 : x;

        while (x > 0) {
            result = result * 10;
            result += x % (10 * multiplier) / multiplier;
            x -= x % (10 * multiplier);
            multiplier *= 10;
        }

        if (result > Integer.MAX_VALUE) return 0;
        return isNegative ? (int) (result * -1) : (int) result;
    }
}
