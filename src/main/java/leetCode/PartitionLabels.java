package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String str) {
        Map<Character, Integer> lastAppearCharIndex = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            lastAppearCharIndex.put(str.charAt(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); ++i) {
            end = Math.max(end, lastAppearCharIndex.get(str.charAt(i)));
            if (i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}
