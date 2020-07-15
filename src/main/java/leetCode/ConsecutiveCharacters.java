package leetCode;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int ans = 1, max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ans++;
            } else {
                ans = 1;
            }
            max = Math.max(ans, max);
        }
        return max;
    }
}
