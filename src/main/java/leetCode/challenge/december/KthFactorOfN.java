package leetCode.challenge.december;

public class KthFactorOfN {
    public int kthFactor(int n, int k) {
        int factorCount = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && ++factorCount == k) {
                return i;
            }
        }
        return -1;
    }
}
