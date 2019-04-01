package algorithms.mazeGenerators;

/**
 * The Empty Maze Generator extands AMazeGenerator and implements IMazeGenerator.
 * it generate an empty maze without walls and many paths with solution.
 *
 * @author may & hay
 */

public class EmptyMazeGenerator extends AMazeGenerator {
    /**
     * This method is used to generate a empty maze.
     * we create a grid full of 0's.
     * @param row This is the first paramter to generate method
     * @param col  This is the second parameter to generate method
     * @return Maze This returns the maze we create.
     */
    @Override
    public Maze generate(int row, int col) {
        Maze grid=new Maze(row,col);
        return grid;
    }
}
