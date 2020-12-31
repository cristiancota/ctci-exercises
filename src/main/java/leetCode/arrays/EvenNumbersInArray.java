package leetCode.arrays;

public class EvenNumbersInArray {
    public int findNumbers(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            if (numberHasEvenDigits(num)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean numberHasEvenDigits(int number) {
        int length = 0;
        int temp = 1;

        while (temp <= number) {
            length++;
            temp *= 10;
        }

        return length % 2 == 0;
    }
}
