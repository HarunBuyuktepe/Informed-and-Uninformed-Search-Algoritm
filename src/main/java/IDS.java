import java.util.ArrayList;

public class IDS {

    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();

    public ArrayList<LabyrinthNodes> applyIDS(Maze maze, int startNode){
        int depth = 0;
        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];
        LabyrinthNodes goalNode = null;

        while (goalNode == null){
            goalNode = DLS(currentNode,depth,exploredSet,ourMaze);
            depth++;
        }

        System.out.println("Harun Baba on the air");

        return exploredSet;
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









