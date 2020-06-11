package leetCode;

import java.util.HashMap;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            map.merge(key, 1, Integer::sum);
        }

        for (int i = 0; i < J.length(); i++) {
            if (map.get(J.charAt(i)) != null) {
                ans += map.get(J.charAt(i));
            }
        }

        return ans;
    }
}
