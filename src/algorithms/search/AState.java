package algorithms.search;

import java.util.ArrayList;
import java.util.Objects;

public abstract class AState {
    private AState cameFrom;
    private int cost;

    public AState(AState cameFrom,int cost) {
       this.cameFrom = cameFrom;
        this.cost = cost;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract String toString();

    public void setCameFrom(AState cameFrom){
        this.cameFrom=cameFrom;
    }

    public AState getCameFrom() {
        return cameFrom;
    }
}
