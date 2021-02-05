package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            Integer integer = map.get(num);
            map.put(num, integer + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                ans = Math.max(ans, entry.getValue() + map.get(entry.getKey() + 1));
            }
        }

        return ans;
    }
}
