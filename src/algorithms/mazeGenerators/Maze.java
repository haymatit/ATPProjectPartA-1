package algorithms.mazeGenerators;
/**
 * The Maze is a class that describe a maze game
 * there are a two-dimensional array of integers that contain the grid
 * there are a Position startPosition that shows where the maze starts
 * there are a Position endPosition that shows where the maze ends
 *
 * @author may & hay
 */
public class Maze {
    private  int [][] grid;
    public static final char PASSAGE_CHAR = '0';
    public static final char WALL_CHAR = '▓';
    private Position startPosition;
    private Position goalPosition;
    private int rowSize;
    private int colSize;

    public Maze(int row, int col) {
        grid=new int[row][col];
        this.goalPosition=new Position(row-1,col-1);
        this.startPosition=new Position(0,0);
        rowSize=row;
        colSize=col;
    }

    public Maze(int[][] grid,Position startPosition,Position goalPosition){
        this.grid=grid;
        this.goalPosition=goalPosition;
        this.startPosition=startPosition;
        rowSize=grid.length;
        colSize=grid[0].length;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return colSize;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public void print(){

        StringBuffer b = new StringBuffer();
        for ( int x = 0; x < grid[0].length + 2; x++ )
            b.append(WALL_CHAR);
        b.append( '\n' );
        for ( int x = 0; x < grid.length; x++ ) {
            b.append(WALL_CHAR);
            for (int y = 0; y < grid[0].length; y++) {
                if (startPosition.getRowIndex() == x && startPosition.getColumnIndex() == y)
                    b.append("S");
                else if (goalPosition.getRowIndex() == x && goalPosition.getColumnIndex() == y)
                    b.append("E");
                else
                    b.append(grid[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
            }
            b.append(WALL_CHAR);
            b.append('\n');
        }
        for ( int x = 0; x < grid[0].length + 2; x++ )
            b.append( WALL_CHAR );
        b.append( '\n' );
        /*
        for(int i=0;i<grid.length;i++){
            System.out.println();
            for(int j=0;j<grid[0].length;j++){
                if(startPosition.getRowIndex()==i && startPosition.getColumnIndex()==j)
                    System.out.print("S");
                else if(goalPosition.getRowIndex()==i && goalPosition.getColumnIndex()==j)
                    System.out.print("E");
                else
                    System.out.print(grid[i][j]);
            }
        }*/
        System.out.print(b);
    }

    public void setStartPosition(int row, int col) {
        this.startPosition=new Position(row,col);
    }

    public void setGoalPosition(int row, int col) {
        this.goalPosition=new Position(row,col);
    }

    public int getPositionType(int row,int col){
        return grid[row][col];
    }

}
