package algorithms.search;
import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState> stack= new Stack<>();
    HashSet<AState> visits=new HashSet<>();

    public DepthFirstSearch() {
        super("Depth First Search");
    }

    public Solution solve(ISearchable s){
        //s.reset();
        stack.push(s.getStartState());
        //s.changeToVisit(s.getStartState());
        visits.add(s.getStartState());
        AState end=null;
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            numberOfNodesEvaluated++;
            if (tmp.equals(s.getEndState())){
                end=tmp;
                break;
            }
            ArrayList<AState> possibleStates= s.getAllPossibleStates(tmp);
            Collections.shuffle(possibleStates);
            for(int i=0;i<possibleStates.size();i++) {
                AState node=possibleStates.get(i);
                if(!visits.contains(node)) {
                    //s.changeToVisit(node);
                    visits.add(node);
                    stack.push(node);
                    node.setCameFrom(tmp);
                }
            }
        }
        Solution sol=new Solution(end);
        return sol;
    }

}
