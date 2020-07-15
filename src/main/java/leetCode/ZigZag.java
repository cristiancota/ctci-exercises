package leetCode;

import java.util.ArrayList;

public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        ArrayList<ArrayList<String>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) rows.add(new ArrayList<>()); // initialize rows

        int index = 0;
        int i = -1;
        boolean down = true;

        while (index < s.length()) {
            if (i == 0) down = true;
            if (i == numRows - 1) down = false;
            i = down ? i + 1 : i - 1;
            rows.get(i).add(String.valueOf(s.charAt(index)));
            index++;
        }

        StringBuilder result = new StringBuilder();
        rows.forEach(strings -> strings.forEach(result::append));

        return result.toString();
    }
}
