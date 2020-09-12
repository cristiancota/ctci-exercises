package leetCode;

import java.util.ArrayList;
import java.util.List;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        List<Character> list = new ArrayList<>();
        int xCount = 0;
        int oCount = 0;

        for (String s : board) {
            for (int i = 0; i < s.toCharArray().length; i++) {
                char current = s.charAt(i);
                if (current == 'X') {
                    xCount++;
                }
                if (current == 'O') {
                    oCount++;
                }
                list.add(current);
            }
        }

        return isValidBoard(list, xCount, oCount);
    }

    private boolean isValidBoard(List<Character> list, int xCount, int oCount) {
        if (xCount - oCount != 0 && xCount - oCount != 1) {
            return false;
        }

        final boolean xWinning = isWinning(list, 'X');
        final boolean oWinning = isWinning(list, 'O');

        if (xWinning && !oWinning && oCount == xCount) {
            return false;
        }

        if (!xWinning && oWinning && oCount != xCount) {
            return false;
        }

        return !xWinning || !oWinning;
    }

    private boolean isWinning(List<Character> list, char c) {
        String[] possibleWinners = new String[]{"012", "345", "678", "036", "147", "258", "048", "246"};
        for (String s : possibleWinners) {
            if (list.get(getIndex(s, 0)) == c && list.get(getIndex(s, 1)) == c && list.get(getIndex(s, 2)) == c) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(String s, int i) {
        return s.charAt(i) - 48;
    }
}
