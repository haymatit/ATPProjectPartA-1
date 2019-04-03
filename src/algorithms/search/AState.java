package algorithms.search;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AState {
    private AState cameFrom;
    private int cost;

    public int getCost() {
        return cost;
    }

    public AState(AState cameFrom, int cost) {
       this.cameFrom = cameFrom;
        this.cost = cost;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AState mState = (AState) o;
//        return (this.cost==mState.cost);
//    }
//
//    public int compare(AState s2) {
//        if(this.getCost() < s2.getCost())
//            return 1;
//        else if(this.getCost()>s2.getCost())
//            return -1;
//        return 0;
//    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public abstract String toString();

    public void setCameFrom(AState cameFrom){
        this.cameFrom=cameFrom;
    }

    public AState getCameFrom() {
        return cameFrom;
    }

    public void updateCost(int newCost){
        cost=newCost;
    }
}
