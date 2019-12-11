import java.util.ArrayList;
import java.util.Collections;
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
                return new Result(getPath(exploredSet.get(exploredSet.size()-1),ourMaze[17]),exploredSet,cost);
            }
            else if (currentNode.getCond().equals(LabyrinthNodes.Condition.Trap)) cost+=6;

            long position = currentNode.getPosition();
            long right = position + 1;long down = position + 8;
            long left = position - 1;long up = position - 8;
            if (currentNode.getCanGo("up")){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=up){
                    ourMaze[(int) up].parent=currentNode;
                    frontier.push(ourMaze[(int) up]);
                }else if(currentNode.parent.getPosition()==up){
                    frontier.push(ourMaze[(int) up]);
                }
            }if (currentNode.getCanGo("left")){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=left){
                    ourMaze[(int) left].parent=currentNode;
                    frontier.push(ourMaze[(int) left]);
                }else if(currentNode.parent.getPosition()==left){
                    frontier.push(ourMaze[(int) left]);
                }
            }if (currentNode.getCanGo("down")){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=down){
                    ourMaze[(int) down].parent=currentNode;
                    frontier.push(ourMaze[(int) down]);
                }else if(currentNode.parent.getPosition()==down){
                    frontier.push(ourMaze[(int) down]);
                }
            }if (currentNode.getCanGo("right")){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=right){
                    ourMaze[(int) right].parent=currentNode;
                    frontier.push(ourMaze[(int) right]);
                }else if(currentNode.parent.getPosition()==right){
                    frontier.push(ourMaze[(int) right]);
                }
            }
            exploredSet.add(currentNode);

        }
        return new Result(getPath(exploredSet.get(exploredSet.size()-1),ourMaze[17]),exploredSet,cost);
    }
    public ArrayList<LabyrinthNodes> getPath(LabyrinthNodes target,LabyrinthNodes start){
        ArrayList<LabyrinthNodes> path = new ArrayList<LabyrinthNodes>();
        for(LabyrinthNodes node = target; node!=null; node = node.parent){
            if(node.equals(start)){
                path.add(node);
                break;
            }
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args){
        DFS dfs1=new DFS();


        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result set = dfs1.applyDFS(maze,17);
        System.out.println(set.cost);
        System.out.println("Cost of DFS" + " " + set.cost);
        System.out.println("Expnaded List");
        Iterator<LabyrinthNodes> iterator6 = set.expandedSet.iterator();
        while (iterator6.hasNext()) {
            System.out.print(iterator6.next().toString()+" \t-->\t ");
            if(iterator6.hasNext())
               System.out.println(iterator6.next().toString());
        }
        System.out.println("\nSolution Path");
        Iterator<LabyrinthNodes> piterator6 = set.solutionPath.iterator();
        while (piterator6.hasNext()) {
            System.out.print(piterator6.next().toString()+" \t-->\t ");
            System.out.println(piterator6.next().toString());
        }


    }
}
