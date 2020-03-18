package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

class ArraysAndStrings {

    boolean isUnique(String s) {
        HashSet<String> hashSet = new HashSet<String>();

        for (String str : s.split(""))
            if (!hashSet.add(str)) return false;

        return true;
    }

    boolean arePermutation(String a, String b) {
        int xor = 0;

        for (char c : a.toCharArray()) xor ^= c;
        for (char c : b.toCharArray()) xor ^= c;

        return xor == 0;
    }

    String urlify(String str, int trueLength) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();

        for (int i = 0; i < trueLength; i++)
            stringBuilder.append(chars[i] == ' ' ? "%20" : chars[i]);

        return stringBuilder.toString();
    }


    boolean isPalindromePermutation(String word) {
        char[] chars = word.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i += 2)
            if (chars[i] != chars[i + 1]) {
                if (chars.length % 2 != 0) i--;
                else return false;
            }

        return true;
    }

    boolean isOneAway(String s1, String s2) {

        int diffs = 0;

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffs++;
                    if (diffs > 1) {
                        return false;
                    }
                }
            }
        } else {
            String longest = s1.length() > s2.length() ? s1 : s2;
            String shortest = s1.length() < s2.length() ? s1 : s2;

            if (longest.length() - shortest.length() > 1) {
                return false;
            }

            int i = 0;
            int j = 0;

            while (diffs <= 1 && i < longest.length() && j < longest.length()) {
                if (i == longest.length() - 1 && i == j) {
                    return true;
                }

                if (longest.charAt(i) != shortest.charAt(j)) {
                    if (longest.charAt(i + 1) == shortest.charAt(j)) {
                        i++;
                        diffs++;
                    } else if (longest.charAt(i) == shortest.charAt(j + 1)) {
                        j++;
                        diffs++;
                    } else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }

    String stringCompression(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                counter++;
            } else {
                stringBuilder.append(str.charAt(i)).append(counter);
                counter = 1;
            }
        }

        stringBuilder.append(str.charAt(str.length() - 1)).append(counter);

        return stringBuilder.toString().length() > str.length() ? str : stringBuilder.toString();
    }

}
