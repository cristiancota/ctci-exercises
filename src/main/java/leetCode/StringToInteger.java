package leetCode;

public class StringToInteger {

    public int myAtoi(String str) {
        if (str.isEmpty()) return 0;

        boolean isNegative = false;
        long result = 0;
        int start = 0;

        while (str.charAt(start) == ' ') {
            start++;
            if (start >= str.length()) {
                return 0;
            }
        }

        if (str.charAt(start) == '-' || str.charAt(start) == '+') {
            if (str.charAt(start) == '-') {
                isNegative = true;
            }

            start++;
        }

        if (start >= str.length() || str.charAt(start) < '0' || str.charAt(start) > '9') {
            return 0;
        }


        for (int i = start; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            }

            if (result > Integer.MAX_VALUE) {
                break;
            }

            result *= 10;
            result += Character.getNumericValue(str.charAt(i));
        }

        if (isNegative) {
            result = result * -1;
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        return (int) result;
    }
}
