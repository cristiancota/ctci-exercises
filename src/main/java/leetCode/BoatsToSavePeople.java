package leetCode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int counter = people.length;

        while (start < end) {
            if (people[start] + people[end] <= limit) {
                counter--;
                start++;
            }
            end--;
        }

        return counter;
    }
}
