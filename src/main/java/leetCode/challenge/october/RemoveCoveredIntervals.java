package leetCode.challenge.october;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1] - a[0]));
        Set<Integer> excluded = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            final int[] smallerInterval = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                if (!excluded.contains(i)) {
                    final int[] currentInterval = intervals[j];
                    if (currentInterval[0] <= smallerInterval[0] && currentInterval[1] >= smallerInterval[1]) {
                        excluded.add(i);
                    }
                }
            }
        }

        return intervals.length - excluded.size();
    }
}
