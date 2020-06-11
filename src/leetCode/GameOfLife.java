package leetCode;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] original = new int[board.length][];
        for (int i = 0; i < board.length; i++)
            original[i] = board[i].clone();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getNextState(i, j, original);
            }
        }
    }

    private int getNextState(int row, int column, int[][] original) {
        boolean isAlive = original[row][column] == 1;
        int aliveNeighbors = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < original.length) { // if i is in bounds
                for (int j = column - 1; j <= column + 1; j++) {
                    if (i != row || j != column) { // if is not the current itself
                        if (j >= 0 && j < original[i].length) { // if j is in bounds
                            if (original[i][j] == 1) { // if neighbor is alive
                                aliveNeighbors++;
                            }
                        }
                    }
                }
            }
        }

        if (isAlive && aliveNeighbors < 2 || isAlive && aliveNeighbors > 3) {
            return 0;
        }

        if (!isAlive && aliveNeighbors == 3) {
            return 1;
        }

        return original[row][column];
    }
}
