package algorithms.search;
/**
 * The ASearchingAlgorithm is a abstract class that implements ISearchingAlgorithm.
 * it override only the method getNumberOfNodesEvaluated that returns the amount of nodes evaluated in the algorithm.
 *
 * @author may & hay
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm{
    private String name;
    protected int numberOfNodesEvaluated;

    public ASearchingAlgorithm(String name) {
        this.name = name;
        this.numberOfNodesEvaluated=0;
    }

    public String getName(){
        return name;
    }

    public int getNumberOfNodesEvaluated(){
        return numberOfNodesEvaluated;
    }
}
