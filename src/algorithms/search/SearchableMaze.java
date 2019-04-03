package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
/**
 * The SearchableMaze implements ISearchable, the class describes the  Maze Problem.
 * it forces every class that implements him to implement:?
 * the method getStartState that gives the start state of the problem.
 * the method getEndState that gives the end state of the problem.
 * the method getAllPossibleStates returns the successors of some state in the problem.
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

    private boolean addToList(ArrayList<AState> neighbors,int i, int j,int cost){
        if(i<0||j<0||i>=grid.getRowSize()||j>=grid.getColSize())
            return false;
        else if(grid.getPositionType(i,j)==0) {
            MazeState MS=new MazeState(new Position(i, j));
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
