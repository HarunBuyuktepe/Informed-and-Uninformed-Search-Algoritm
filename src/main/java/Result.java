import java.util.ArrayList;

public class Result {
    ArrayList<LabyrinthNodes> exploredSet;
    ArrayList<LabyrinthNodes> expandedSet;int cost;
    Result(ArrayList<LabyrinthNodes> exploredSet,ArrayList<LabyrinthNodes> expandedSet, int cost){
        this.cost=cost;
        this.exploredSet=exploredSet;
        this.expandedSet=expandedSet;
    }
}
