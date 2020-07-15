package leetCode;

public class SubstractProductAndSum {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int current = n % 10;
            sum += current;
            product *= current;
            n -= current;
            n /= 10;
        }
        return product - sum;
    }
}
