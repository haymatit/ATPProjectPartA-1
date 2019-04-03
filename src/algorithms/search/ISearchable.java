package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    public AState getStartState();
    public AState getEndState();
    public ArrayList<AState> getAllPossibleStates(AState state);
//    public void changeToVisit(AState s);
//    public void reset();
//    public void updateCostFromEnd(AState state);
}
