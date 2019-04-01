package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 * My Maze Generator extends AMazeGenerator and implements IMazeGenerator.
 * it generate an complex maze with walls and a path with solution,
 * using Prim algorithm.
 *
 * @author may & hay
 */
public class MyMazeGenerator extends AMazeGenerator{
    /**
     * This method is used to generate a complex maze.
     * we use the Prim algorithm to create the grid.
     * @param row This is the first paramter to generate method
     * @param col  This is the second parameter to generate method
     * @return Maze This returns the maze we create.
     */
    @Override
    public Maze generate(int row, int col) {
        int[][] grid = new int[row][col];
        /*setting all the grid to walls*/
        gridWalls(grid);
        Position start = new Position(0, 0);
        ArrayList<int[]> neighbors = new ArrayList<>();
        /*craving paths*/
        int x=0,y=0,xe=0,ye=0;
        neighbors.add(new int[]{x, y, x, y});
        Random random = new Random();
        while (!neighbors.isEmpty()) {//Prim- problem when even
            int[] f = neighbors.remove(random.nextInt(neighbors.size()));
            x = f[2];
            y = f[3];
            if (grid[x][y] == 1) {
                grid[f[0]][f[1]] = grid[x][y] = 0;
                if (x >= 2 && grid[x - 2][y] == 1)
                    neighbors.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && grid[x][y - 2] == 1)
                    neighbors.add(new int[]{x, y - 1, x, y - 2});
                if (x < row - 2 && grid[x + 2][y] == 1)
                    neighbors.add(new int[]{x + 1, y, x + 2, y});
                if (y < col - 2 && grid[x][y + 2] == 1)
                    neighbors.add(new int[]{x, y + 1, x, y + 2});
            }
            if(neighbors.size()<=1){
                xe=x;
                ye=y;
            }
        }
        Position end = new Position(xe, ye);
        Maze my=new Maze(grid,start,end);
        return my;
    }
/* not good
    private Position endPath(int[][] grid) {
        Random random = new Random();
        int xE=0,yE=0;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[grid.length-2][j]==0) {
                    grid[grid.length - 1][j] = random.nextInt(2);
                    yE=j;
                }
            }
            if(grid[i][grid[0].length-2]==0) {
                grid[i][grid[0].length - 1] = random.nextInt(2);
                xE=i;
            }
        }
        return new Position(xE, yE);
    }
*/
    private void gridWalls(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=1;
            }
        }
    }
}
