package leetCode;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            int index = 0;
            int limit = Math.min(firstWord.length(), secondWord.length());
            while (index < limit) {
                if (firstWord.charAt(index) == secondWord.charAt(index)) {
                    index++;
                    continue;
                }
                if (map.get(firstWord.charAt(index)) > map.get(secondWord.charAt(index))) {
                    return false;
                } else {
                    break;
                }
            }
            if (secondWord.length() < firstWord.length() && index >= limit) {
                return false;
            }
        }
        return true;
    }
}
