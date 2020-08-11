package leetCode;

import java.util.*;

public class SortIntegersByThePowerValue {
    public int getKth(int lo, int hi, int k) {
        // TODO add memo
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = lo; i <= hi; i++)
            map.put(i, getPowerValue(i));
        LinkedHashMap<Integer, Integer> sorted = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
        int i = 1;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            if (i == k)
                return entry.getKey();
            i++;
        }
        return -1;
    }

    public int getPowerValue(int num) {
        int ans = 0;
        while (num > 1) {
            if ((num & 1) == 0)
                num = num / 2;
            else
                num = (3 * num) + 1;
            ans++;
        }
        return ans;
    }
}
