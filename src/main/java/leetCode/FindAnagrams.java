package leetCode;

import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        String sortedWord = sortString(p);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length() - p.length(); i++) {
            String sorted = sortString(s.substring(i, i + p.length()));
            if (sorted.equals(sortedWord)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private String sortString(String inputString) {
        char[] tempArray = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
