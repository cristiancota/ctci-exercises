package leetCode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Temperature> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            int iTemp = T[i];

            while (!stack.isEmpty() && iTemp > stack.peek().value) {
                Temperature removedTemp = stack.pop();
                ans[removedTemp.index] = i - removedTemp.index;
            }

            stack.push(new Temperature(iTemp, i));
        }

        return ans;
    }

    static class Temperature {
        int value;
        int index;

        public Temperature(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

