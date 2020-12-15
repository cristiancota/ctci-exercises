package leetCode.challenge.december;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            int prev = i - 1;
            int next = i + 1;

            if ((prev < 0 || flowerbed[prev] == 0) && (next == len || flowerbed[next] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }

        return n == 0;
    }
}
