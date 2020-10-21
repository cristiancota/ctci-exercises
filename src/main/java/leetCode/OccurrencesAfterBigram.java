package leetCode;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 2; i < split.length; i++) {
            if (split[i - 2].equals(first) && split[i - 1].equals(second)) {
                result.add(split[i]);
            }
        }

        return result.toArray(new String[0]);
    }
}