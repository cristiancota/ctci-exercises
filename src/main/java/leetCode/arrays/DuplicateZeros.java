package leetCode.arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int[] original = arr.clone();
        int index = 0;
        for (int i = 0; index < arr.length; i++) {
            if (original[i] == 0) {
                arr[index] = 0;
                index++;
                if (index < arr.length) {
                    arr[index] = 0;
                }
            } else {
                arr[index] = original[i];
            }
            index++;
        }
    }
}
