package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;
/**
 * The Solution is a class that describes the solution of maze game
 * there are a AState that saves the end of the game.
 * the method getSolutionPath returns ArrayList of the path.
 *
 * @author may & hay
 */
public class Solution {
    AState endState;
    public Solution(AState endState) {
        this.endState=endState;
    }

    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> pathSol=new ArrayList<>();
        Stack<AState> stack= new Stack<>();
        AState skipper=endState;
        /*stack to turn over the order of the path*/
        while(skipper!=null){
            stack.push(skipper);
            skipper=skipper.getCameFrom();
        }
        /*then we enter the states by order to the ArrayList*/
        skipper=stack.pop();
        while(!stack.empty()) {
            pathSol.add(skipper);
            skipper=stack.pop();
        }
        pathSol.add(skipper);
        return pathSol;
    }
}
