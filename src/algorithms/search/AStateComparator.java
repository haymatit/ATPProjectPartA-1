package algorithms.search;
import java.util.Comparator;
/**
 * The AStateComparator is a class we create for the PriorityQueue-
 * so it could compare between 2 AStates, by their costs.
 *
 * @author may & hay
 */
public class AStateComparator implements Comparator<AState> {
    @Override
    public int compare(AState s1, AState s2) {
        if(s1.getCost() < s2.getCost())
            return 1;
        else if(s1.getCost()>s2.getCost())
            return -1;
        return 0;
    }
}
