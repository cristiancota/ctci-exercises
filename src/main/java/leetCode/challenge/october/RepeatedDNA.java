package leetCode.challenge.october;

import java.util.*;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String substring = s.substring(i - 10, i);
            if (!set.add(substring)) {
                repeated.add(substring);
            }
        }

        return new ArrayList<>(repeated);
    }
}
