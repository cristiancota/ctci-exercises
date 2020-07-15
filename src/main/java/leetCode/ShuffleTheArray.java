package leetCode;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[i / 2];
        }

        for (int i = 1; i < nums.length; i += 2) {
            result[i] = nums[n + (i / 2)];
        }

        return result;
    }
}
