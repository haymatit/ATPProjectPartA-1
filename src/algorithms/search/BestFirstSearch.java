package algorithms.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;
/**
 * The BestFirstSearch extends BreadthFirstSearch, that extends ASearchingAlgorithm and implements ISearchingAlgorithm.
 * it override only the Queue from BFS with PriorityQueue and solve the problem using the Best First Search algorithm.
 * that way we can use the same code but with different Data structures.
 * there are a PriorityQueue the algorithm use.
 * and there are a HashSet the algorithm needs to track the visits nodes(from BFS).
 *
 * @author may & hay
 */
public class BestFirstSearch extends BreadthFirstSearch{

    public BestFirstSearch() {
        super("Best First Search");
        queue =new PriorityQueue<>(new AStateComparator());;
    }


 //   public Solution solve(ISearchable s){
//        return super.solve(s);
  //  }

//    private boolean checkEmpty(){
//        return queue.isEmpty();
//    }
//
//    private AState structerPop(){
//        return queue.poll();
//    }
//
//    private void structerPush(AState state){
//        queue.add(state);
//    }
}

//public class BestFirstSearch extends ASearchingAlgorithm{
//    PriorityQueue<AState> Pqueue=new PriorityQueue<>(new AStateComperator());
//
//    public BestFirstSearch() {
//        super("Best First Search");
//    }
//
//
//    public Solution solve(ISearchable s){
//        s.reset();
//        structerPush(s.getStartState());
//        s.changeToVisit(s.getStartState());
//        s.updateCostFromEnd(s.getStartState());
//        AState end=null;
//
//        while(!checkEmpty()) {
//            AState tmp = structerPop();
//            numberOfNodesEvaluated++;
//            if (tmp.equals(s.getEndState())){
//                end=tmp;
//                break;
//            }
//            ArrayList<AState> possibleStates= s.getAllPossibleStates(tmp);
//            for(int i=0;i<possibleStates.size();i++) {
//                AState node=possibleStates.get(i);
//                s.updateCostFromEnd(node);
//                s.changeToVisit(node);
//                structerPush(node);
//                node.setCameFrom(tmp);
//
//            }
//        }
//        Solution sol=new Solution(end);
//        return sol;
//    }
//
//    private boolean checkEmpty(){
//        return Pqueue.isEmpty();
//    }
//
//    private AState structerPop(){
//        return Pqueue.remove();
//    }
//
//    private void structerPush(AState state){
//        Pqueue.add(state);
//    }
//}