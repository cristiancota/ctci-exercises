package leetCode;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int result = 0;
        for (int i = 0; i < rating.length; i++) {
            int first = rating[i];
            for (int j = i + 1; j < rating.length; j++) {
                int second = rating[j];
                if (first > second) { // desc
                    result += findDesc(rating, j, second);
                } else { // asc
                    result += findAsc(rating, j, second);
                }
            }
        }
        return result;
    }

    private int findDesc(int[] rating, int indexBase, int target) {
        int count = 0;
        for (int i = indexBase + 1; i < rating.length; i++) {
            if (rating[i] < target) {
                count++;
            }
        }
        return count;
    }

    private int findAsc(int[] rating, int indexBase, int target) {
        int count = 0;
        for (int i = indexBase + 1; i < rating.length; i++) {
            if (rating[i] > target) {
                count++;
            }
        }
        return count;
    }
}
