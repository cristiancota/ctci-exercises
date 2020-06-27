package leetCode;

public class Palindrome {
    public boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) return true;

        int left = 0;
        int right = input.length() - 1;

        while (left <= right) {
            char leftChar = input.charAt(left);
            if (isNonAlphanumeric(leftChar)) {
                left++;
                continue;
            }

            char rightChar = input.charAt(right);
            if (isNonAlphanumeric(rightChar)) {
                right--;
                continue;
            }

            if (charsAreDifferentIgnoringCase(leftChar, rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean charsAreDifferentIgnoringCase(char leftChar, char rightChar) {
        leftChar = leftChar > 96 ? (char) (leftChar - 32) : leftChar;
        rightChar = rightChar > 96 ? (char) (rightChar - 32) : rightChar;
        return leftChar != rightChar;
    }

    private boolean isNonAlphanumeric(char currentChar) {
        return (currentChar < 48 || currentChar > 57)
                && (currentChar < 65 || currentChar > 90)
                && (currentChar < 97 || currentChar > 122);
    }
}
