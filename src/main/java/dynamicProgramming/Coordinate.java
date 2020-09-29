package dynamicProgramming;

import java.util.Objects;

class Coordinate {
    private int _row;
    private int _column;

    Coordinate(int row, int column) {
        _row = row;
        _column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return _row == that._row &&
                _column == that._column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_row, _column);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "_row=" + _row +
                ", _column=" + _column +
                '}';
    }
}
