package leetCode.challenge.october;

public class ComplementOfBase10 {
    public int bitwiseComplement(int N) {
        if(N == 0) { return 1; }

        int[] num = new int[32];

        for (int i = 0; i < 32; i++) {
            if (N > 0) {
                num[i] = (N & 1) == 1 ? 0 : 1;
                N >>= 1;
            } else {
                break;
            }
        }

        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            if (num[i] == 1) {
                ans += Math.pow(2, i);
            }
        }

        return ans;
    }
}
