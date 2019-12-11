import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class IDS {

    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();
    ArrayList<LabyrinthNodes> expandedSet = new ArrayList<>();
    int cost=0;

    public Result applyIDS(Maze maze, int startNode){
        int depth = 0;
        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];
        LabyrinthNodes goalNode = null;
        LabyrinthNodes start=ourMaze[17];
        while (goalNode == null){
            goalNode = DLS(currentNode,depth,exploredSet,ourMaze);
            if(goalNode==null)exploredSet.clear();
            depth++;
        }

        System.out.println("Harun Baba on the air");

        return new Result(exploredSet,exploredSet,cost);
    }
    public LabyrinthNodes DLS(LabyrinthNodes currentNode,int depth,ArrayList<LabyrinthNodes> exploredSet,LabyrinthNodes[] ourMaze){
        exploredSet.add(currentNode);
        if (depth == 0 && currentNode.getCond() == LabyrinthNodes.Condition.Goal) {
            return currentNode;
        }
        if (depth > 0){
            LabyrinthNodes g=null;

            long position = currentNode.getPosition();
            if (currentNode.getCanGo("right")&&(position + 1)<=63){
                long right = position + 1;
                ourMaze[(int) right].parent=currentNode;
                currentNode = ourMaze[(int) right];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("down") && (position - 8)>=0){
                long down = (position - 8);
                ourMaze[(int) down].parent=currentNode;
                currentNode = ourMaze[(int) down];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("left")&&(position - 1)>=0){
                long left = position - 1;
                ourMaze[(int) left].parent=currentNode;
                currentNode = ourMaze[(int) left];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("up")&&(position + 8)<=63){
                long up = position + 8;
                ourMaze[(int) up].parent=currentNode;
                currentNode = ourMaze[(int) up];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }

        }

        return null;
    }
    public ArrayList<LabyrinthNodes> getPath(LabyrinthNodes target,LabyrinthNodes start){
        ArrayList<LabyrinthNodes> path = new ArrayList<LabyrinthNodes>();
        for(LabyrinthNodes node = target; node!=null; node = node.parent){
            if(node.getCond().toString().equals("Trap"))cost+=6;
            else cost++;
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
        IDS a=new IDS();

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result expandedSetAstar = a.applyIDS(maze,17);
        System.out.println(expandedSetAstar.cost);
        System.out.println("Cost of IDS" + " " + expandedSetAstar.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator4 = expandedSetAstar.expandedSet.iterator();
        while (iterator4.hasNext()) {
            System.out.print(iterator4.next().toString()+" \t-->\t ");
            if(iterator4.hasNext())
                System.out.println(iterator4.next().toString());
        }
        System.out.println("Solution Path");
        Iterator<LabyrinthNodes> piterator4 = expandedSetAstar.solutionPath.iterator();
        while (piterator4.hasNext()) {
            System.out.print(piterator4.next().toString()+" \t-->\t ");
            if(piterator4.hasNext())
                System.out.println(piterator4.next().toString());
        }


    }



}









