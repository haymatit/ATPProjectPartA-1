package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
/**
 * The SearchableMaze implements ISearchable, the class describes the Maze Problem.
 * it override the getters for the start state and the end state,
 * and the method getAllPossibleStates that returns the successors of some state in the Maze problem.
 *
 * @author may & hay
 */
public class SearchableMaze implements ISearchable{
    Maze grid;
    MazeState endState;
    MazeState startState;
    //boolean [][] visits;

    public SearchableMaze(Maze m) {
        this.grid=m;
        endState=new MazeState(grid.getGoalPosition());
        startState=new MazeState(grid.getStartPosition());
        //visits=new boolean[m.getRowSize()][m.getColSize()];
    }

    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getEndState() {
        return endState;
    }
    /**
     * This method is used to find the next possible states in the maze.
     * we take the next cell if they are: up,down,left or right.
     * then if we can move to some of those cells we take cell at an angle from our current cell.
     * we use the private method addToList that take cares that the cell is legal.
     *
     * @param state This is the first parameter to getAllPossibleStates method
     * @return ArrayList<AState> This returns the successors of some state.
     */
    @Override
    public ArrayList<AState> getAllPossibleStates(AState state) {
        MazeState currentM=(MazeState)state;
        Position currentP=currentM.getCurrentPosition();
        ArrayList<AState> neighbors=new ArrayList<>();
        int i=currentP.getRowIndex();
        int j=currentP.getColumnIndex();
        if(addToList(neighbors,i-1,j,3)) {
            addToList(neighbors, i - 1, j - 1,2);
            addToList(neighbors, i - 1, j + 1,2);
        }
        if(addToList(neighbors,i+1,j,3)){
            addToList(neighbors,i+1,j-1,2);
            addToList(neighbors,i+1,j+1,2);
        }
        if(addToList(neighbors,i,j-1,3)){
            addToList(neighbors,i+1,j-1,2);
            addToList(neighbors,i-1,j-1,2);
        }
        if(addToList(neighbors,i,j+1,3)){
            addToList(neighbors,i+1,j+1,2);
            addToList(neighbors,i-1,j+1,2);
        }
        return neighbors;
    }
    /**
     * This method make sure that the cell we get is legal.
     * we check if the indexes are in the grid bounds,
     * if the list of neighbors does not contains this cell,
     * and if this cell is a way and not a wall.
     * after those tests we update the cost of the state with the parameter we got.
     *
     * @param neighbors This is the first parameter to getAllPossibleStates method
     * @param i This is the second parameter to getAllPossibleStates method
     * @param j This is the third parameter to getAllPossibleStates method
     * @param cost This is the fourth parameter to getAllPossibleStates method
     * @return ArrayList<AState> This returns the successors of some state.
     */
    private boolean addToList(ArrayList<AState> neighbors,int i, int j,int cost){
        MazeState MS=new MazeState(new Position(i, j));
        if(neighbors.contains(MS))
            return false;
        if(i<0||j<0||i>=grid.getRowSize()||j>=grid.getColSize())
            return false;
        else if(grid.getPositionType(i,j)==0) {
            neighbors.add(MS);
            MS.updateCost(cost);
            return true;
        }
        return false;
    }

//    public void reset(){
//        for(int i=0;i<visits.length;i++){
//            for (int j=0;j<visits[0].length;j++)
//                visits[i][j]=false;
//        }
//    }

//    public void changeToVisit(AState s){
//        MazeState m=(MazeState)s;
//        visits[m.getCurrentPosition().getRowIndex()][m.getCurrentPosition().getColumnIndex()]=true;
//    }

//    public void updateCostFromEnd(AState state){
//        MazeState Ms=(MazeState) state;
//        Position P=Ms.getCurrentPosition();
//        Position Pe=endState.getCurrentPosition();
//        int cost=Math.abs(P.getRowIndex()-Pe.getRowIndex())+Math.abs(P.getColumnIndex()-Pe.getColumnIndex());
//        state.updateCost(cost);
//    }

}
