package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    AState endState;
    public Solution(AState endState) {
        this.endState=endState;
    }

    public ArrayList<AState> getSolutionPath(){
        ArrayList<AState> pathSol=new ArrayList<>();
        Stack<AState> stack= new Stack<>();
        AState skipper=endState;
        while(skipper!=null){
            stack.push(skipper);
            skipper=skipper.getCameFrom();
        }
        skipper=stack.pop();
        while(!stack.empty()) {
            pathSol.add(skipper);
            skipper=stack.pop();
        }
        pathSol.add(skipper);
        return pathSol;
    }
}
