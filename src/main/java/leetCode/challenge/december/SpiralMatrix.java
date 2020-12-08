package leetCode.challenge.december;

public class SpiralMatrix {
    public int[][] generateMartix(int n) {
        int[][] ans = new int[n][n];
        int current = 1;
        int limit = n * n;
        int i = 0;
        int j = 0;
        int direction = 1;

        while (current <= limit) {
            ans[i][j] = current;

            switch (direction) {
                case 1: // go right
                    if (j < n - 1 && ans[i][j + 1] == 0) {
                        j++;
                    } else {
                        i++;
                        direction = 2;
                    }
                    break;
                case 2: // go down
                    if (i < n - 1 && ans[i + 1][j] == 0) {
                        i++;
                    } else {
                        j--;
                        direction = 3;
                    }
                    break;
                case 3: // go left
                    if (j > 0 && ans[i][j - 1] == 0) {
                        j--;
                    } else {
                        i--;
                        direction = 4;
                    }
                    break;
                case 4: // go up
                    if (i > 0 && ans[i - 1][j] == 0) {
                        i--;
                    } else {
                        j++;
                        direction = 1;
                    }
                    break;
            }
            current++;
        }

        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.generateMartix(3);
    }
}
