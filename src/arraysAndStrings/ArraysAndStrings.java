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

}
