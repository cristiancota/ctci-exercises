package leetCode;

import java.util.Arrays;

public class Candy {
    public int getTotalCandies(int[] ratings) {
        int ratingsLength = ratings.length;
        int[] candies = new int[ratingsLength];
        int i = 0;
        int ac = 0;
        int startedConsecutive = -1;

        while (i < candies.length - 1) {
            int current = ratings[i];
            int next = ratings[i + 1];

            if (current < next) {
                candies[i] = ac;
                ac++;
                startedConsecutive = -1;
            } else {
                if (current == next) {
                    candies[i] = ac;
                    startedConsecutive = -1;
                } else {
                    candies[i] = ac == 0 ? 1 : ac;

                    if (startedConsecutive > -1) {
                        for (int j = i; j > startedConsecutive; j--) {
                            if (candies[j] >= candies[j - 1]) {
                                candies[j - 1] = candies[j - 1] + 1;
                            }
                        }
                    }

                    if (startedConsecutive == -1) {
                        startedConsecutive = i;
                    }
                }

                ac = 0;
            }

            i++;
        }

        if (ratingsLength > 1) {
            if (ratings[ratingsLength - 1] > ratings[ratingsLength - 2]) {
                candies[ratingsLength - 1] = candies[ratingsLength - 2] + 1;
            }
        } else {
            return 1;
        }

        return Arrays.stream(candies).sum() + ratingsLength;
    }
}
