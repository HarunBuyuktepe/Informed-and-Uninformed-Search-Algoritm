import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    Queue<LabyrinthNodes> frontier = new LinkedList<>();
    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();

    public Result applyBFS(Maze maze, int startNode){
        int cost=0;
        LabyrinthNodes[] ourMaze = maze.getMaze();
        frontier.add(ourMaze[startNode]);
        LabyrinthNodes currentNode;

        boolean success = false;
        while (!frontier.isEmpty()){
            LabyrinthNodes enqueue = frontier.remove();
            currentNode = enqueue;
            cost++;
            if (exploredSet.contains(currentNode))continue;

            if (currentNode.getCond().equals(LabyrinthNodes.Condition.Goal)){
                success = true;
                //System.out.println("goal state "+exploredSet.size()+" "+currentNode.getCond().toString()+" "+currentNode.getPosition());
                exploredSet.add(currentNode);
                return new Result(exploredSet,exploredSet,cost);
            }
            else if(currentNode.getCond().equals(LabyrinthNodes.Condition.Trap)) cost+=6;

            long position = currentNode.getPosition();
            if (currentNode.getCanGo("up")){
                long up = position - 8;
                frontier.add(ourMaze[(int) up]);
            }
            if (currentNode.getCanGo("down")){
                long down = position + 8;
                frontier.add(ourMaze[(int) down]);
            }
            if (currentNode.getCanGo("right")){
                long right = position + 1;
                frontier.add(ourMaze[(int) right]);
            }
            if (currentNode.getCanGo("left")){
                long left = position - 1;
                frontier.add(ourMaze[(int) left]);
            }
            exploredSet.add(currentNode);
        }


        return new Result(exploredSet,exploredSet,cost);
    }
}
