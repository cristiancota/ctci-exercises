package leetCode;

import java.util.TreeMap;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W > 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();
            map.put(first, map.get(first) - 1);
            if (map.get(first) == 0) {
                map.remove(first);
            }

            for (int i = 1; i < W; i++) {
                int target = first + i;
                if (!map.containsKey(target)) {
                    return false;
                }
                map.put(target, map.get(target) - 1);
                if (map.get(target) == 0) {
                    map.remove(target);
                }
            }
        }

        return true;
    }
}
