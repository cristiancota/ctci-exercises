package leetCode.challenge.october;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        for (int i = 0; i < k; i++) {
            rotate(nums);
        }
    }

    private void rotate(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }
}
