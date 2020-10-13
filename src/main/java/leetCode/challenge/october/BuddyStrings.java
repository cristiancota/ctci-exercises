package leetCode.challenge.october;

import java.util.Arrays;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2 || (A.length() != B.length())) {
            return false;
        }

        int[] countArray = new int[26];
        int first = -1;
        int second = -1;
        int count = 0;

        for (int i = 0; i < A.length() && count < 2; i++) {
            countArray[A.charAt(i) - 97] = countArray[A.charAt(i) - 97] + 1;
            if (A.charAt(i) != B.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else {
                    second = i;
                }
                count++;
            }
        }

        if (count == 0) {
            for (int i = 0; i < 26; i++) {
                if (countArray[i] > 1) {
                    return true;
                }
            }

            return false;
        }

        if (count == 1) {
            return false;
        }

        StringBuilder builder = new StringBuilder();

        builder.append(A, 0, first);
        builder.append(A.charAt(second));
        builder.append(A, first + 1, second);
        builder.append(A.charAt(first));
        builder.append(A.substring(second + 1));

        return builder.toString().equals(B);    }
}
