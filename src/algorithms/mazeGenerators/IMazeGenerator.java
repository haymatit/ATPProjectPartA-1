package algorithms.mazeGenerators;
/**
 * The IMazeGenerator is a interface
 * it forces every class that implements him to implement:
 * the method measureAlgorithmTimeMillis that measure the time of an algorithm
 * the method generate that generate a Maze
 *
 * @author may & hay
 */
public interface IMazeGenerator {
    public Maze generate(int row, int col);
    public long measureAlgorithmTimeMillis(int row, int col);
}
