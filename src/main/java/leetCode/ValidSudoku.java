package leetCode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> currentRow = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (Character.isDigit(current)) {
                    if (!currentRow.add(current)) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> currentColumn = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char current = board[j][i];
                if (Character.isDigit(current)) {
                    if (!currentColumn.add(current)) {
                        return false;
                    }
                }
            }
        }

        for (int column = 0; column < 9; column += 3) {
            for (int row = 0; row < 9; row += 3) {
                Set<Character> currentSquare = new HashSet<>();
                for (int i = column; i < column + 3; i++) {
                    for (int j = row; j < row + 3; j++) {
                        char current = board[i][j];
                        if (Character.isDigit(current)) {
                            if (!currentSquare.add(current)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}