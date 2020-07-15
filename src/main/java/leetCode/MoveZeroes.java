package leetCode;

public class MoveZeroes {
    int[] moveZeroes(int[] array) {
        int z = 0;
        int a = 0;

        while (z < array.length && a < array.length - 1) {
            if (array[a] == 0) {
                z = findNextNonZero(array, z);
                if (z == -1) break;
                swap(array, a, z);
            } else {
                z++;
            }
            a++;
        }

        return array;
    }

    private void swap(int[] array, int a, int z) {
        int temp = array[a];
        array[a] = array[z];
        array[z] = temp;
    }

    private int findNextNonZero(int[] array, int z) {
        for (int i = z; i < array.length; i++) {
            if (array[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}
