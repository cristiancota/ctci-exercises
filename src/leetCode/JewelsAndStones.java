package leetCode;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) != -1) { ans++; }
        }
        return ans;
    }
}
