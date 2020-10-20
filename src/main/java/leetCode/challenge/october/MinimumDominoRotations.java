package leetCode.challenge.october;

import java.util.Arrays;

public class MinimumDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 0) {
            return 0;
        }

        int[] count = new int[4];
        int target = A[0];

        count[0] = getCount(A, B, target);
        count[1] = count[0] > -1 ? getCount(B, A, target) : -1; // if there's no way up, there is no way down for A[0]

        target = B[0];

        count[2] = getCount(B, A, target);
        count[3] = count[2] > -1 ? getCount(A, B, target) : -1;

        Arrays.sort(count);
        for (int c : count) {
            if (c > -1) {
                return c;
            }
        }

        return -1;
    }

    private int getCount(int[] A, int[] B, int target) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) {
                if (B[i] == target) {
                    count++;
                } else {
                    return -1;
                }
            }
        }
        return count;
    }
}
