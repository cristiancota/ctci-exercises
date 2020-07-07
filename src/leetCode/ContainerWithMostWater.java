package leetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int start;
        int end;
        while (i < j) {
            start = height[i];
            end = height[j];
            int current = Math.min(start, end) * (j - i);
            max = Math.max(max, current);
            if (start < end) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
