package leetCode;

import java.util.*;

public class SortIntegersByOnes {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < 32; i++) {
            list.add(i, new ArrayList<>());
        }
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
            List<Integer> integers = list.get(currentOnes);
            integers.add(arr[i]);
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        int[] ans = new int[arr.length];
        int currentIndex = 0;
        for (int i = 0; i <= maxOnes; i++) {
            Integer[] integers = list.get(i).toArray(new Integer[0]);
            for (int i1 = 0; i1 < integers.length; i1++) {
                ans[currentIndex] = integers[i1];
                currentIndex++;
            }
        }
        return ans;
    }
}
