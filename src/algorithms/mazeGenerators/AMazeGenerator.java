package algorithms.mazeGenerators;
/**
 * The AMazeGenerator is a abstract class that implements IMazeGenerator
 * it override only the method measureAlgorithmTimeMillis that measure the time
 *
 * @author may & hay
 */
public abstract class AMazeGenerator implements IMazeGenerator{
    @Override
    public long measureAlgorithmTimeMillis(int row, int col) {
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return (after-before);
    }

}