package leetCode.challenge.october;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) continue;
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                return search(matrix[i], target) != -1;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int index, low = 0, high = nums.length - 1;
        while (low <= high) {
            index = low + (high - low) / 2;
            if (nums[index] == target) return index;
            if (target < nums[index]) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        return -1;
    }
}
