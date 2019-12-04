import java.util.ArrayList;
import java.util.Iterator;

public class IDS {

    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();
    ArrayList<LabyrinthNodes> expandedSet = new ArrayList<>();

    public int getIterativeCost(ArrayList<LabyrinthNodes> exploredSetIDS) {
        int cost=0;
        ArrayList<LabyrinthNodes> newList = getExploredSet(exploredSetIDS);
        Iterator<LabyrinthNodes> iterator3 = newList.iterator();
        while (iterator3.hasNext()) {
            if (iterator3.next().getCond().toString().equals("Normal")) cost++;
            else if(iterator3.next().getCond().toString().equals("Trap") )cost+=6;
        }
        return cost;
    }
    public ArrayList<LabyrinthNodes> getExploredSet(ArrayList<LabyrinthNodes> exploredSetIDS){
        int last=exploredSetIDS.lastIndexOf(exploredSetIDS.get(0));
        ArrayList<LabyrinthNodes> newList = new ArrayList<LabyrinthNodes>();
        for (int i=last;i<exploredSetIDS.size();i++){
            newList.add(exploredSetIDS.get(i));
        }
        return newList;
    }

    public Result applyIDS(Maze maze, int startNode){
        int depth = 0;
        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];
        LabyrinthNodes goalNode = null;

        while (goalNode == null){
            goalNode = DLS(currentNode,depth,exploredSet,ourMaze);
            depth++;
        }

        System.out.println("Harun Baba on the air");

        return new Result(exploredSet,getExploredSet(exploredSet),getIterativeCost(exploredSet));
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
                currentNode = ourMaze[(int) right];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("left")&&(position - 1)>=0){
                long left = position - 1;
                currentNode = ourMaze[(int) left];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("up")&&(position + 8)<=63){
                long up = position + 8;
                currentNode = ourMaze[(int) up];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }if (currentNode.getCanGo("down") && (position - 8)>=0){
                long down = (position - 8);
                currentNode = ourMaze[(int) down];
                g=DLS(currentNode,depth-1,exploredSet,ourMaze);
                if(g!=null) return g;
            }

        }

        return null;
    }



}









