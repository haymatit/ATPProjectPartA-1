package algorithms.search;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState> stack= new Stack<>();


    public DepthFirstSearch() {
        super("Depth First Search");
    }

    public Solution solve(ISearchable s){

        stack.push(s.getStartState());
        AState end=null;
        //s.reset();
        while(!stack.isEmpty()) {
            AState tmp = stack.pop();
            numberOfNodesEvaluated++;

            if (tmp.equals(s.getEndState())){
                end=tmp;
                break;
            }
            ArrayList<AState> possibleStates= s.getAllPossibleStates(tmp);
            for(int i=0;i<possibleStates.size();i++) {
                AState node=possibleStates.get(i);
                s.changeToVisit(node);
                stack.push(node);
                node.setCameFrom(tmp);

            }
        }
        Solution sol=new Solution(end);
        return sol;
    }

}
