package dynamicProgramming;

import java.util.Arrays;

public class DynamicProgramming {

    int naiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
    }

    long fibonacciMemo(int n) {
        return fibonacciMemoHelper(n, new int[n + 1]);
    }

    private long fibonacciMemoHelper(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
        return memo[n];
    }


    int fibonacciMemoBottomUp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }

    long fibonacciMemoBottomUpImproved(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;
        for (int i = 2; i < n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }


    int tripleStep(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return tripleStepMemo(n, memo);
    }

    int tripleStepMemo(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = tripleStepMemo(n - 1, memo) + tripleStepMemo(n - 2, memo) + tripleStepMemo(n - 3, memo);
            return memo[n];
        }
    }
}
