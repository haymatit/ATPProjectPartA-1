package test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;
import java.util.ArrayList;
public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(1000, 1000);
        //maze.print();//we added

        SearchableMaze searchableMaze = new SearchableMaze(maze);


        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());


    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        //Solve a searching problem with a searcher
        long before=System.currentTimeMillis();//we added
        Solution solution = searcher.solve(domain);
        long after=System.currentTimeMillis();//we added
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
                //Printing Solution Path
        System.out.println("time:"+(after-before));//we added
        System.out.println("Solution path:");
        int i = 0;
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (i = 0; i < solutionPath.size(); i++) {
            //System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
        System.out.println(i);
    }
}
