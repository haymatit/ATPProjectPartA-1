package algorithms.search;
/**
 * The ISearchingAlgorithm is a interface that describes the Searching Algorithm.
 * it forces every class that implements him to implement:
 * the method solve that solving the problem with some algorithm.
 * the method getNumberOfNodesEvaluated that returns the amount of nodes evaluated in the algorithm.
 * the method getName returns the name of the algorithm we use.
 *
 * @author may & hay
 */
public interface ISearchingAlgorithm {
    public Solution solve(ISearchable s);
    public int getNumberOfNodesEvaluated();
    public String getName();
}
