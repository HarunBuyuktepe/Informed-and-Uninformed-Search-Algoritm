import java.util.ArrayList;
import java.util.Iterator;
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

            if (exploredSet.contains(currentNode))continue;
            cost++;
            if (currentNode.getCond().equals(LabyrinthNodes.Condition.Goal)){
                success = true;
                //System.out.println("goal state "+exploredSet.size()+" "+currentNode.getCond().toString()+" "+currentNode.getPosition());
                exploredSet.add(currentNode);
                return new Result(exploredSet,exploredSet,cost);
            }
            else if (currentNode.getCond().equals(LabyrinthNodes.Condition.Trap)) cost+=6;

            long position = currentNode.getPosition();
            if (currentNode.getCanGo("up")){
                long up = position - 8;
                frontier.push(ourMaze[(int) up]);
            }if (currentNode.getCanGo("left")){
                long left = position - 1;
                frontier.push(ourMaze[(int) left]);
            }if (currentNode.getCanGo("down")){
                long down = position + 8;
                frontier.push(ourMaze[(int) down]);
            }if (currentNode.getCanGo("right")){
                long right = position + 1;
                frontier.push(ourMaze[(int) right]);
            }
            exploredSet.add(currentNode);

        }
        return new Result(exploredSet,exploredSet,cost);
    }
    public static void main(String[] args){
        DFS a=new DFS();
        System.out.println("Harun Baba");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result expandedSetAstar = a.applyDFS(maze,17);
        System.out.println(expandedSetAstar.cost);
        System.out.println("Cost of DFS" + " " + expandedSetAstar.cost);
        Iterator<LabyrinthNodes> iterator4 = expandedSetAstar.expandedSet.iterator();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next().toString());
        }
        System.out.println("ne");
        Iterator<LabyrinthNodes> piterator4 = expandedSetAstar.exploredSet.iterator();
        while (piterator4.hasNext()) {
            System.out.println(piterator4.next().toString());
        }


    }
}
