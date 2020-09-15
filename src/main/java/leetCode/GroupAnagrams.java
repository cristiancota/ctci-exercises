package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = Arrays.toString(charArray);
            if (map.get(sortedKey) == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedKey, list);
            } else {
                List<String> list = map.get(sortedKey);
                list.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
