package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new CopyOnWriteArrayList<List<String>>();
        for (String currentString : strs) {
            if (result.isEmpty()) {
                List<String> strings = new ArrayList<>();
                strings.add(currentString);
                result.add(new ArrayList<>(strings));
            } else {
                for (int i = 0; i < result.size(); i++) {
                    List<String> list = result.get(i);
                    if (isAnagram(currentString, list.get(0))) {
                        list.add(currentString);
                        break;
                    }
                    if (i == result.size() - 1) {
                        List<String> strings = new ArrayList<>();
                        strings.add(currentString);
                        result.add(new ArrayList<>(strings));
                        break;
                    }
                }
            }
        }

        return result;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
