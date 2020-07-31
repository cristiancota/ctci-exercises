package leetCode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                int total = map.get(num);
                map.put(num, total + 1);
            }
            map.put(num, 0);
        }
        return map.values().stream().mapToInt(value -> {
            if (value > 1) {
                return value;
            } else {
                return 0;
            }
        }).sum();
    }
}
