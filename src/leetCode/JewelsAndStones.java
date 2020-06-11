package leetCode;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (J.indexOf(key) >= 0) {
                map.merge(key, 1, Integer::sum);
            }
        }

        return map.values().stream().mapToInt(i -> i).sum();
    }
}
