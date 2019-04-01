package algorithms.search;

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
