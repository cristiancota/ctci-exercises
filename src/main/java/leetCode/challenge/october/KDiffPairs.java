package leetCode.challenge.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int value : nums) {
            String index = String.valueOf(value);
            map.putIfAbsent(index, 0);
            Integer integer = map.get(index);
            integer++;
            map.put(index, integer);
        }

        Arrays.sort(nums);

        Set<String> existing = new HashSet<>();
        int ans = 0;

        for (int num : nums) {
            String numString = String.valueOf(num);
            String upper = String.valueOf(num + k);

            if ((existing.contains(upper) && existing.contains(numString))) {
                continue;
            }

            if (k != 0) {
                if (map.get(upper) != null) {
                    existing.add(numString);
                    existing.add(upper);
                    ans++;
                }
            } else {
                if (map.get(upper) > 1 && !existing.contains(upper)) {
                    existing.add(upper);
                    ans++;
                }
            }
        }

        return ans;
    }
}