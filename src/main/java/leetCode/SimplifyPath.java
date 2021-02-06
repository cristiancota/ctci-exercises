package leetCode;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            String token = split[i];
            if (!stack.isEmpty() && "..".equals(token)) {
                stack.pop();
            } else if (!Arrays.asList(".", "", "..").contains(token)) {
                stack.push(token);
            }
        }

        return "/" + String.join("/", stack);
    }
}
