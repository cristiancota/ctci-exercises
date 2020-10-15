package leetCode.challenge.october;


public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] array1 = new int[k];
        int[] array2 = new int[nums.length - k];

        System.arraycopy(nums, nums.length - k, array1, 0, k);
        System.arraycopy(nums, 0, array2, 0, nums.length - k);

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                nums[i] = array1[i];
            } else {
                nums[i] = array2[i - k];
            }
        }
    }
}
