package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable{
    Maze grid;
    MazeState endState;
    MazeState startState;
    boolean [][] visits;

    public SearchableMaze(Maze m) {
        this.grid=m;
        endState=new MazeState(grid.getGoalPosition());
        startState=new MazeState(grid.getStartPosition());
        visits=new boolean[m.getRowSize()][m.getColSize()];
    }

    public void reset(){
        for(int i=0;i<visits.length;i++){
            for (int j=0;j<visits[0].length;j++)
                visits[i][j]=false;
        }
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
        ArrayList<AState> neighboors=new ArrayList<>();
        int i=currentP.getRowIndex();
        int j=currentP.getColumnIndex();
        if(addToList(neighboors,i-1,j)) {
            addToList(neighboors, i - 1, j - 1);
            addToList(neighboors, i - 1, j + 1);
        }
        if(addToList(neighboors,i+1,j)){
            addToList(neighboors,i+1,j-1);
            addToList(neighboors,i+1,j+1);
        }
        if(addToList(neighboors,i,j-1)){
            addToList(neighboors,i+1,j-1);
            addToList(neighboors,i-1,j-1);
        }
        if(addToList(neighboors,i,j+1)){
            addToList(neighboors,i+1,j+1);
            addToList(neighboors,i-1,j+1);
        }
        return neighboors;
    }

    public void changeToVisit(AState s){
        MazeState m=(MazeState)s;
        visits[m.getCurrentPosition().getRowIndex()][m.getCurrentPosition().getColumnIndex()]=true;
    }
    private boolean addToList(ArrayList<AState> neighboors,int i, int j){
        if(i<0||j<0||i>=grid.getRowSize()||j>=grid.getColSize())
            return false;
        else if(grid.getPositionType(i,j)==0&&visits[i][j]==false) {
            neighboors.add(new MazeState(new Position(i, j)));
            return true;
        }
        return false;
    }

    public void updateCostFromEnd(AState state){
        MazeState Ms=(MazeState) state;
        Position P=Ms.getCurrentPosition();
        Position Pe=endState.getCurrentPosition();
        int cost=Math.abs(P.getRowIndex()-Pe.getRowIndex())+Math.abs(P.getColumnIndex()-Pe.getColumnIndex());
        state.updateCost(cost);
    }

}
