package leetCode.challenge.october;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1] - a[0]));
        Set<Integer> excluded = new HashSet<>();
        int ans = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i; j < intervals.length; j++) {
                if (!excluded.contains(i)) {
                    if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                        excluded.add(i);
                        ans--;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
