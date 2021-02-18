package leetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int distance = right - left;

            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * distance);
                left++;
            } else {
                max = Math.max(max, height[right] * distance);
                right--;
            }
        }

        return max;
    }
}
