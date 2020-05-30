package leetCode;

import java.util.*;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                final int current = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (current > bound || current < 0) break;
                result.add(current);
            }
        }

        return new ArrayList<>(result);
    }
}
