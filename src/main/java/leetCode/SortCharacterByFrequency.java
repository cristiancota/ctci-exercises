package leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            map.putIfAbsent(currentChar, 0);
            map.put(currentChar, map.get(currentChar) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < entry.getValue(); i++)
                        sb.append(entry.getKey());
                    return sb;
                }).collect(Collectors.joining());
    }
}
