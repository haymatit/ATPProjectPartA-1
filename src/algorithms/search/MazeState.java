package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.Objects;
/**
 * The MazeState extends AState, the class describes the state in a Maze.
 * it override only the method we need for HashSet- equals, toString, and the getters and setters.
 *
 * @author may & hay
 */
public class MazeState extends AState{
    private Position current;

    public MazeState(Position current) {
        super(null,1);
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mState = (MazeState) o;
        return this.current.equals(mState.current);
    }

    @Override
    public String toString() {
        return current.toString();
    }

    public Position getCurrentPosition() {
        return current;
    }

//    public MazeState(MazeState cameFrom,Position current) {
//        super(cameFrom);
//        this.current = current;
//        this.cost = 1;
//    }
}
