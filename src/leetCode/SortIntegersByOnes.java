package leetCode;

import java.util.*;

public class SortIntegersByOnes {
    public int[] sortByBits(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int currentOnes = 0;
            while (current > 0) {
                if (current % 2 > 0) {
                    currentOnes++;
                }
                current >>= 1;
            }
            if (map.get(currentOnes) != null) {
                List<Integer> integers = map.get(currentOnes);
                integers.add(arr[i]);
                map.put(currentOnes, integers);
            } else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(arr[i]);
                map.put(currentOnes, integers);
            }

            maxOnes = Math.max(maxOnes, currentOnes);
        }
        return map.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                map(integerListEntry -> {
                    Integer[] objects = integerListEntry.getValue().toArray(new Integer[0]);
                    Arrays.sort(objects);
                    return Arrays.asList(objects);
                }).
                flatMap(Collection::parallelStream).
                mapToInt(Integer::intValue).
                toArray();
    }
}
