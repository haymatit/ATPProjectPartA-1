package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{
    LinkedList<AState> queue=new LinkedList<>();
    public BreadthFirstSearch() {
        super("Breadth First Search");
    }

    protected BreadthFirstSearch(String name) {
        super(name);
    }

    public Solution solve(ISearchable s){
        s.reset();
        structerPush(s.getStartState());
        s.changeToVisit(s.getStartState());
        s.updateCostFromEnd(s.getStartState());
        AState end=null;

        while(!checkEmpty()) {
            AState tmp = structerPop();
            numberOfNodesEvaluated++;
            if (tmp.equals(s.getEndState())){
                end=tmp;
                break;
            }
            ArrayList<AState> possibleStates= s.getAllPossibleStates(tmp);
            for(int i=0;i<possibleStates.size();i++) {
                AState node=possibleStates.get(i);
                s.updateCostFromEnd(node);
                s.changeToVisit(node);
                structerPush(node);
                node.setCameFrom(tmp);

            }
        }
        Solution sol=new Solution(end);
        return sol;
    }

    private boolean checkEmpty(){
        return queue.isEmpty();
    }

    private AState structerPop(){
        return queue.poll();
    }

    private void structerPush(AState state){
        queue.add(state);
    }


}
