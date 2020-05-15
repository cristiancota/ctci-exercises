package leetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class MatchstickstoSquare {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        final int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) return false;
        final int goal = sum / 4;

        Integer[] list = IntStream.of(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(list, Collections.reverseOrder());

        if (list[0] > goal) return false;

        for (int i = 0; i < 4; i++) {
            int current = list[i];
            if (current == goal) {
                continue;
            }

            for (int j = 4; j < list.length; j++) {
                if (current + list[j] == goal) {
                    list[j] = 0;
                    list[i] = goal;
                    break;
                }

                if (j == list.length - 1) {
                    for (int k = 4; k < list.length; k++) {
                        if (list[k] > 0 && current + list[k] < goal) {
                            list[i] = current + list[k];
                            list[k] = 0;
                            i--;
                            break;
                        }

                        if (k == list.length - 1) return false;
                    }
                }
            }
        }

        return true;
    }
}
