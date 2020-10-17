package leetCode.challenge.october;

import java.util.*;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() == 10) { return Collections.emptyList(); }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String substring = s.substring(i - 10, i);
            map.putIfAbsent(substring, 0);
            map.put(substring, map.get(substring) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() > 1) {
                ans.add(stringIntegerEntry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        RepeatedDNA repeatedDNA = new RepeatedDNA();
        repeatedDNA.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
