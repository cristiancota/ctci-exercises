package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NRepeatedElement {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                return A[i];
            }
        }
        return -1;
    }

    public int repeatedNTimesWithSet(int[] A) { // way faster but uses more memory
        Set<Integer> set = new HashSet<>();
        for (int value : A) {
            if (!set.add(value)) {
                return value;
            }
        }
        return -1;
    }
}
