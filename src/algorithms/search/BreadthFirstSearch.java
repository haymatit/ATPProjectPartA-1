package algorithms.search;
import java.util.*;
/**
 * The BreadthFirstSearch extends ASearchingAlgorithm and implements ISearchingAlgorithm.
 * it override only the method solve that returns the Solution of the problem using the Breadth First Search algorithm.
 * there are a Queue the algorithm use.
 * and there are a HashSet the algorithm needs to track the visits nodes.
 *
 * @author may & hay
 */
public class BreadthFirstSearch extends ASearchingAlgorithm{
    Queue<AState> queue;
    HashSet<AState> visits=new HashSet<>();
    public BreadthFirstSearch() {
        super("Breadth First Search");
        queue=new LinkedList<>();
    }

    protected BreadthFirstSearch(String name) {
        super(name);
    }
    /**
     * This method solve the search problem we get.
     * we take searchable problem and start to run on it from the start state- enter to the queue.
     * while we have nodes in the queue we need to visit:
     * every node we take out from the queue we check if this node is the end state.
     * if not, we take the successors of this node and check if every node is visited.
     * if not, the successor is turning into visited, we update the node we came from and enter it to the queue.
     * when the end founds, we return the Solution with the path we discover.
     *
     * @param ISearchable This is the first parameter to solve method
     * @return Solution This returns the Solution of the problem.
     */
    public Solution solve(ISearchable s){
        //s.reset();
        queue.add(s.getStartState());
//        s.changeToVisit(s.getStartState());
//        s.updateCostFromEnd(s.getStartState());
        visits.add(s.getStartState());
        AState end=null;
        while(!queue.isEmpty()) {
            AState tmp = queue.poll();
            numberOfNodesEvaluated++;
            if (tmp.equals(s.getEndState())){
                end=tmp;
                break;
            }
            ArrayList<AState> possibleStates= s.getAllPossibleStates(tmp);
            //Collections.shuffle(possibleStates);
            for(int i=0;i<possibleStates.size();i++) {
                AState node=possibleStates.get(i);
//                s.updateCostFromEnd(node);
//                s.changeToVisit(node);
                if(!visits.contains(node)) {
                    //s.changeToVisit(node);
                    visits.add(node);
                    queue.add(node);
                    node.setCameFrom(tmp);
                }
            }
        }
        Solution sol=new Solution(end);
        return sol;
    }

//    //private boolean checkEmpty(){
//        return queue.isEmpty();
//    }

//    private AState structerPop(){
//        return queue.poll();
//    }

//    private void structerPush(AState state){
//        queue.add(state);
//    }


}
