import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    Stack<LabyrinthNodes> frontier = new Stack<>();
    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();

    public Result applyDFS(Maze maze, int startNode){
        int cost=0;
        LabyrinthNodes[] ourMaze = maze.getMaze();
        frontier.push(ourMaze[startNode]);
        LabyrinthNodes currentNode;

        boolean success = false;
        while (!frontier.empty()){
            currentNode = frontier.pop();
            cost++;
            if (exploredSet.contains(currentNode))continue;

            if (currentNode.getCond().equals(LabyrinthNodes.Condition.Goal)){
                success = true;
                //System.out.println("goal state "+exploredSet.size()+" "+currentNode.getCond().toString()+" "+currentNode.getPosition());
                exploredSet.add(currentNode);
                return new Result(exploredSet,exploredSet,cost);
            }
            else if (currentNode.getCond().equals(LabyrinthNodes.Condition.Trap)) cost+=6;

            long position = currentNode.getPosition();
            if (currentNode.getCanGo("down")){
                long down = position + 8;
                frontier.push(ourMaze[(int) down]);
            }if (currentNode.getCanGo("up")){
                long up = position - 8;
                frontier.push(ourMaze[(int) up]);
            }if (currentNode.getCanGo("left")){
                long left = position - 1;
                frontier.push(ourMaze[(int) left]);
            }if (currentNode.getCanGo("right")){
                long right = position + 1;
                frontier.push(ourMaze[(int) right]);
            }
            exploredSet.add(currentNode);

        }
        return new Result(exploredSet,exploredSet,cost);
    }
}
