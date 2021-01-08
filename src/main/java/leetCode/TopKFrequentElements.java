package leetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                limit(k).
                forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            ans[i] = entry.getKey();
            i++;
        }

        return ans;
    }
}
