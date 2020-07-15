package leetCode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c))
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                Character pop = stack.pop();
                if (!isMatching(pop, c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isMatching(char start, char end) {
        switch (start) {
            case '(':
                return end == ')';
            case '[':
                return end == ']';
            case '{':
                return end == '}';
        }
        return false;
    }
}
