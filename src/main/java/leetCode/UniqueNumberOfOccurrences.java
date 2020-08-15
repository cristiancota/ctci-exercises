package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int number : arr) {
            int prevValue = counts.getOrDefault(number, 0);
            counts.put(number, ++prevValue);
        }
        Set<Integer> e = new HashSet<>();
        for (Integer value : counts.values())
            if (!e.add(value))
                return false;
        return true;
    }
}
