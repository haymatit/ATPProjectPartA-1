package algorithms.search;

import java.util.Comparator;

public class AStateComperator implements Comparator<AState> {
    @Override
    public int compare(AState s1, AState s2) {
        if(s1.getCost() < s2.getCost())
            return 1;
        else if(s1.getCost()>s2.getCost())
            return -1;
        return 0;
    }
}
