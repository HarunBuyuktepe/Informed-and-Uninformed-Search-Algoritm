import java.util.ArrayList;

public class Result {
    ArrayList<LabyrinthNodes> solutionPath;
    ArrayList<LabyrinthNodes> expandedSet;int cost;
    Result(ArrayList<LabyrinthNodes> solutionPath,ArrayList<LabyrinthNodes> expandedSet, int cost){
        this.cost=cost;
        this.solutionPath=solutionPath;
        this.expandedSet=expandedSet;
    }
}
