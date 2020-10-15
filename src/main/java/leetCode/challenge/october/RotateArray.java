package leetCode.challenge.october;


public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = new int[nums.length];
        System.arraycopy(nums, nums.length - k, copy, 0, k);
        System.arraycopy(nums, 0, copy, k, nums.length - k);
        System.arraycopy(copy, 0, nums, 0, nums.length);
    }
}
