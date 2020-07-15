package leetCode;

import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        int i = 0;
        int max = 1;
        String result = "";

        StringBuilder builder = new StringBuilder();
        while (paragraph.length() > i) {
            final char c = paragraph.charAt(i);

            if (!Character.isSpaceChar(c)) {
                if (Character.isLetter(c)) {
                    builder.append(c);
                }
            }

            if (builder.length() > 0 && (!Character.isLetter(c) || i == paragraph.length() - 1)) {
                final String key = builder.toString().toLowerCase();
                if (map.get(key) == null) {
                    if (!bannedSet.contains(key)) {
                        if (map.isEmpty()) {
                            result = key;
                        }
                        map.put(key, 1);
                    }
                } else {
                    final Integer integer = map.get(key);
                    map.put(key, integer + 1);
                    if (integer > max) {
                        result = key;
                        max = integer;
                    }
                }
                builder = new StringBuilder();
            }
            i++;
        }

        return result;
    }
}
