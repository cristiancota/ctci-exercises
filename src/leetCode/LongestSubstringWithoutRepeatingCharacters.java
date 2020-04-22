package leetCode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set;
        int max = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            set = new HashSet<>();

            char[] array = s.toCharArray();
            for (int j = i, arrayLength = array.length; j < arrayLength; j++) {
                Character second = array[j];

                if (!set.add(second)) {
                    max = Math.max(max, j - i);
                    break;
                }
            }

            max = Math.max(set.size(), max);
        }

        return max;
    }
}
