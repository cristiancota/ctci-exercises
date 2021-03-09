package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (wordsSet.contains(word)) {
                for (int i = 1; i < word.length(); i++) {
                    wordsSet.remove(word.substring(i));
                }
            }
        }

        int ans = wordsSet.size();

        for (String word : wordsSet) {
            ans += word.length();
        }

        return ans;
    }
}
