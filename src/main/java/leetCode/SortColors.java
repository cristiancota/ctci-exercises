package leetCode;

public class SortColors {
    public void sortColors(int[] nums) {
        // 1ms
        //Arrays.sort(nums);

        // 0ms
        int pivot = 1;
        int left = 0;
        int index = 0;
        int right = nums.length - 1;

        while (index <= right) {
            if (nums[index] < pivot) {
                swap(nums, index++, left++);
            } else if (nums[index] > pivot) {
                swap(nums, index, right--);
            } else {
                index++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
