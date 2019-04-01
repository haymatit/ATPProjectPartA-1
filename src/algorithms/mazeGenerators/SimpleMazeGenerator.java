package algorithms.mazeGenerators;
/**
 * The Simple Maze Generator extends AMazeGenerator and implements IMazeGenerator
 * it generate an simple maze with walls and a path with solution
 *
 * @author may & hay
 */
public class SimpleMazeGenerator extends AMazeGenerator {
    /**
     * This method is used to generate a simple maze.
     * we create a grid with random walls.
     * @param row This is the first paramter to generate method
     * @param col  This is the second parameter to generate method
     * @return Maze This returns the maze we create.
     */
    @Override
    public Maze generate(int row, int col) {
        int [][]grid=new int[row][col];
        /*building walls*/
        buildWalls(grid);
        /*make a way- break walls*/
        int i=0,j=0,stepper=0;
        while(i<row && j<col){
            grid[i][j]=0;
            stepper=(int) (Math.random()*2);
            if(stepper==0)
                i++;
            else
                j++;
        }
        if(i>=row)
            i--;
        else
            j--;
        Position startPosition=new Position(0,0);
        Position goalPosition=new Position(i,j);
        Maze simple=new Maze(grid,startPosition,goalPosition);
        return simple;
    }

    private void buildWalls(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=(int) (Math.random()*2);
            }
        }
    }
}
