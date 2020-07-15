package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

        List<Integer> missingIntegers = new ArrayList<>();
        List<Integer> remainingIntegers = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (i < 4) {
                if (list[i] < goal) {
                    missingIntegers.add(goal - list[i]);
                }
            } else {
                remainingIntegers.add(list[i]);
            }
        }

        return includesMissing(missingIntegers, remainingIntegers);
    }

    boolean includesMissing(List<Integer> missingIntegers, List<Integer> remainingIntegers) {
        if (remainingIntegers.size() < missingIntegers.size()) return false;
        if (missingIntegers.size() == 1) {
            return remainingIntegers.stream().mapToInt(Integer::intValue).sum() == missingIntegers.get(0);
        }

        for (int i = 0; i < missingIntegers.size(); i++) {
            Integer currentMissing = missingIntegers.get(i);
            if (remainingIntegers.contains(currentMissing)) {
                missingIntegers.set(i, 0);
                remainingIntegers.remove(currentMissing);
            }
        }

        int counter = (int) missingIntegers.stream().filter(integer -> integer > 0).count();
        if (counter == 0 && remainingIntegers.size() == 0) return true;

        Collections.sort(missingIntegers);
        Collections.reverse(missingIntegers);
        List<Integer> newMissing = counter == 1 ? Collections.singletonList(missingIntegers.get(0)) : new ArrayList<>();
        List<Integer> newRemaining = counter == 1 ? remainingIntegers : remainingIntegers.subList(counter, remainingIntegers.size());

        for (int i = 0; i < missingIntegers.size() && missingIntegers.get(i) > 0 && counter > 1; i++) {
            newMissing.add(missingIntegers.get(i) - remainingIntegers.get(i));
        }

        return includesMissing(newMissing, newRemaining);
    }
}
