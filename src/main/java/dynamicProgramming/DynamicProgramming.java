package dynamicProgramming;

import java.util.*;

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
        return tripleStepHelper(n, memo);
    }

    int tripleStepHelper(int n, int[] memo) {
        if (n < 0) // base cases
            return 0;

        if (n <= 1)
            return 1;

        if (memo[n] != 0) { // exists in memo
            return memo[n];
        }

        memo[n] = tripleStepHelper(n - 3, memo) + tripleStepHelper(n - 2, memo) + tripleStepHelper(n - 1, memo);
        return memo[n];
    }

    List<Coordinate> robotInAGrid(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int[] current : memo) {
            Arrays.fill(current, -1);
        }

        List<Coordinate> result = robotInAGridHelper(0, 0, matrix, memo, new ArrayList<>());
        if (result == null) {
            return new ArrayList<>();
        } else {
            Collections.reverse(result);
        }

        return result;
    }

    private List<Coordinate> robotInAGridHelper(int row, int column, int[][] matrix, int[][] memo, ArrayList<Coordinate> result) {
        if (row < 0 || row >= matrix.length) { // if row index s out of limit
            return null;
        }

        if (column < 0 || column >= matrix[0].length) { // if column index is out of limit
            return null;
        }

        if (matrix[row][column] == 0 || memo[row][column] == 0) { // if matrix has "off limits" was visited already
            return null;
        }

        if (row == matrix.length - 1 && column == matrix[0].length - 1) { // arrives to the end
            result.add(new Coordinate(row, column));
            return result;
        }

        memo[row][column] = 1; // mark as visited and can be part of the path

        if ((robotInAGridHelper(row, column + 1, matrix, memo, result) != null) || (robotInAGridHelper(row + 1, column, matrix, memo, result) != null)) {
            result.add(new Coordinate(row, column));
            return result;
        }

        memo[row][column] = 0; // means visited and no eligible for path
        return null;
    }

    int magicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }

        return -1;
    }

    int magicIndexBinary(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        return magicIndexHelper(nums, nums.length / 2);
    }

    private int magicIndexHelper(int[] nums, int mid) {
        final int current = nums[mid];

        if (mid == 0 && mid != current || mid == nums.length - 1 && mid != current) {
            return -1;
        }

        if (current > mid) {
            return magicIndexHelper(nums, mid / 2);
        } else if (current < mid) {
            return magicIndexHelper(nums, (nums.length + mid) / 2);
        } else {
            return mid;
        }
    }

    List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List<Integer> next = new ArrayList<>(ans.get(j));
                next.add(num);
                ans.add(next);
            }
        }
        return ans;
    }

    int recursiveMultiply(int a, int b) {
        return recursiveMultiplyHelper(a, b, 0);
    }

    private int recursiveMultiplyHelper(int a, int b, int result) {
        if (b <= 0) {
            return result;
        }
        return recursiveMultiplyHelper(a, b - 1, result + a);
    }
}
