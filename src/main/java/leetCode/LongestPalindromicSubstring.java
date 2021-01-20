package leetCode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        int maxL = 0;
        int maxR = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (r < s.length() - 1 && s.charAt(l) == s.charAt(r + 1)) {
                r++;
            }

            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if ((r - l) > (maxR - maxL)) {
                    maxR = r;
                    maxL = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(maxL, maxR + 1);
    }
}
