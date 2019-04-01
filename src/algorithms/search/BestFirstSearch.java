package algorithms.search;

import java.util.PriorityQueue;

public class BestFirstSearch extends BreadthFirstSearch{
    PriorityQueue<AState> Pqueue=new PriorityQueue<>(new AStateComperator());

    public BestFirstSearch() {
        super("Best First Search");
    }


    public Solution solve(ISearchable s){
        return super.solve(s);
    }

    private boolean checkEmpty(){
        return Pqueue.isEmpty();
    }

    private AState structerPop(){
        return Pqueue.poll();
    }

    private void structerPush(AState state){
        Pqueue.add(state);
    }
}
