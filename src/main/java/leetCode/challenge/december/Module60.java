package leetCode.challenge.december;

import java.util.HashMap;
import java.util.Map;

public class Module60 {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : time) {
            if (t % 60 == 0) {
                ans += map.getOrDefault(0, 0);
            } else {
                ans += map.getOrDefault(60 - t % 60, 0);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }

        return ans;
    }
}
