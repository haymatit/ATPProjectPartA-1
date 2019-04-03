package algorithms.search;
import java.util.ArrayList;
/**
 * The ISearchable is a interface that describes the Problem that we need to search in.
 * it forces every class that implements him to implement:
 * the method getStartState that gives the start state of the problem.
 * the method getEndState that gives the end state of the problem.
 * the method getAllPossibleStates returns the successors of some state in the problem.
 *
 * @author may & hay
 */
public interface ISearchable {
    public AState getStartState();
    public AState getEndState();
    public ArrayList<AState> getAllPossibleStates(AState state);
//    public void changeToVisit(AState s);
//    public void reset();
//    public void updateCostFromEnd(AState state);
}
