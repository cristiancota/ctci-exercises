package leetCode;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int total = 0;
            int index = satisfaction.length - i;
            for (int j = satisfaction.length - 1; j >= i; j--) {
                total += (index * satisfaction[j]);
                index--;
            }
            max = Math.max(total, max);
        }
        return max;
    }
}
