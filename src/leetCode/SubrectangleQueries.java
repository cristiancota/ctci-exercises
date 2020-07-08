package leetCode;

class SubrectangleQueries {

    private int[][] _matrix;

    public SubrectangleQueries(int[][] rectangle) {
        _matrix = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                _matrix[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        final int[][] ints = {
                {1, 2, 1},
                {4, 3, 4},
                {3, 2, 1},
                {1, 1, 1}
        };
        return _matrix[row][col];
    }
}