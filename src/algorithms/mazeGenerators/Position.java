package algorithms.mazeGenerators;

import java.util.Objects;

/**
 * The Position is a class that describe a cell in the maze game.
 * there are a integer row that shows the row in the position,
 * and there are a integer col that shows the column in the position.
 *
 * @author may & hay
 */
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    /**
     * This method is used to turn the position into String.
     * the format are "{row,col}"
     * @return String This returns the format.
     */
    @Override
    public String toString() {
        return "{" +
                "" + row +
                ", " + col +
                '}';
    }

    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return (getRowIndex() == position.getRowIndex()) &&
                (getColumnIndex() == position.getColumnIndex());
    }

}
