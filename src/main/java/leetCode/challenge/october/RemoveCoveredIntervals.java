package leetCode.challenge.october;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <index,range>
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int a = interval[0];
            int b = interval[1];
            map.put(i, b - a);
        }

        List<Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int counter = 0;
        Set<Integer> excluded = new HashSet<>();

        for (int i = 0; i < sorted.size(); i++) {
            final int[] biggerInterval = intervals[sorted.get(i)];
            for (int j = i + 1; j < sorted.size(); j++) {
                final int[] currentInterval = intervals[sorted.get(j)];
                final int currL = currentInterval[0];
                final int bigL = biggerInterval[0];
                final int currR = currentInterval[1];
                final int bigR = biggerInterval[1];
                if ((currL >= bigL && currR < bigR || currL > bigL && currR <= bigR) && !excluded.contains(j)) {
                    excluded.add(j);
                    counter++;
                }
            }
        }

        return intervals.length - counter;
    }
}
