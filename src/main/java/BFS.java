import java.util.*;

public class BFS {
    int cost=0;
    Queue<LabyrinthNodes> frontier = new LinkedList<>();
    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();

    public Result applyBFS(Maze maze, int startNode){

        LabyrinthNodes[] ourMaze = maze.getMaze();
        frontier.add(ourMaze[startNode]);
        LabyrinthNodes currentNode;

        while (!frontier.isEmpty()){
            LabyrinthNodes enqueue = frontier.remove();
            currentNode = enqueue;

            if (exploredSet.contains(currentNode))continue;
            exploredSet.add(currentNode);
            if (currentNode.getCond().equals(LabyrinthNodes.Condition.Goal)){
                //System.out.println("goal state "+exploredSet.size()+" "+currentNode.getCond().toString()+" "+currentNode.getPosition());
                cost++;
                return new Result(getPath(exploredSet.get(exploredSet.size()-1)),exploredSet,cost);
            }
            else if(currentNode.getCond().toString().equals("Trap"))cost+=6;
            else cost++;

            long position = currentNode.getPosition();
            long right = position + 1;long down = position + 8;
            long left = position - 1;long up = position - 8;
            if (currentNode.getCanGo("right") ){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=right){
                    ourMaze[(int) right].parent=currentNode;
                    frontier.add(ourMaze[(int) right]);
                }else if(currentNode.parent.getPosition()==right){
                    frontier.add(ourMaze[(int) right]);
                }
            }if (currentNode.getCanGo("down") ){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=down){
                    ourMaze[(int) down].parent=currentNode;
                    frontier.add(ourMaze[(int) down]);
                }else if(currentNode.parent.getPosition()==down){
                    frontier.add(ourMaze[(int) down]);
                }
            }if (currentNode.getCanGo("left") ){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=left){
                    ourMaze[(int) left].parent=currentNode;
                    frontier.add(ourMaze[(int) left]);
                }else if(currentNode.parent.getPosition()==left){
                    frontier.add(ourMaze[(int) left]);
                }
            } if (currentNode.getCanGo("up") ){
                if(currentNode.parent==null || currentNode.parent.getPosition()!=up){
                    ourMaze[(int) up].parent=currentNode;
                    frontier.add(ourMaze[(int) up]);
                }else if(currentNode.parent.getPosition()==up){
                    frontier.add(ourMaze[(int) up]);
                }

            }


        }


        return new Result(getPath(exploredSet.get(exploredSet.size()-1)),exploredSet,cost);
    }
    public ArrayList<LabyrinthNodes> getPath(LabyrinthNodes target){
        ArrayList<LabyrinthNodes> path = new ArrayList<LabyrinthNodes>();
        for(LabyrinthNodes node = target; node!=null; node = node.parent){
            path.add(node);
        }

        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args){
        BFS a=new BFS();

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result bfs = a.applyBFS(maze,17);
        System.out.println(bfs.cost);
        System.out.println("Cost of BFS" + " " + bfs.cost);
        Iterator<LabyrinthNodes> iterator4 = bfs.expandedSet.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next().toString()+" \t-->\t ");
            System.out.println(iterator4.next().toString());
        }
        System.out.println("Solution Path");
        Iterator<LabyrinthNodes> piterator4 = bfs.solutionPath.iterator();
        while (piterator4.hasNext()) {
            System.out.print(piterator4.next().toString()+" \t-->\t ");
            System.out.println(piterator4.next().toString());
        }


    }
}