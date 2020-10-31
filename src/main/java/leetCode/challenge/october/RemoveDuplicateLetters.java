package leetCode.challenge.october;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 97] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (visited[currentChar - 97]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > currentChar && lastIndex[stack.peek() - 97] > i) {
                visited[stack.peek() - 97] = false;
                stack.pop();
            }

            stack.push(currentChar);
            visited[currentChar - 97] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }

        return ans.toString();
    }
}
