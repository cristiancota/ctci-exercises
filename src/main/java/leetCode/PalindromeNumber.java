package leetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int result = 0;
        int originalX = x;

        while (x > 0) {
            result *= 10;
            result += x % 10;
            x -= x % 10;
            x /= 10;
        }

        return originalX == result;
    }
}