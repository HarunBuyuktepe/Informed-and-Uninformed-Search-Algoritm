import java.util.*;

public class UCS {

    UCS(){}

    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();

    public ArrayList<LabyrinthNodes> applyUCS(Maze maze, int startNode){

        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];

        PriorityQueue<LabyrinthNodes> priorityQueue = new PriorityQueue<LabyrinthNodes>(64,
                new Comparator<LabyrinthNodes>(){
                    //override compare method
                    public int compare(LabyrinthNodes i, LabyrinthNodes j){
                        if(i.getCond().toString().equals("Goal") && !j.getCond().toString().equals("Goal") ){
                            return 1;
                        }
                        else if (i.getCond().toString().equals("Trap")){
                            return -1;
                        }
                        else{
                            return 0;
                        }
                    }
                }
        );
        priorityQueue.add(currentNode);
        boolean success=false;


        while (!priorityQueue.isEmpty() && !success){
            currentNode = priorityQueue.remove();
            exploredSet.add(currentNode);
            Main.costUCS++;
            if (currentNode.getCond().toString().equals("Goal")){
                success = true;
                return exploredSet;
            }
            else if(currentNode.getCond().toString().equals("Trap"))Main.costUCS+=6;

            long position = currentNode.getPosition();
            long up = position - 8;
            if (currentNode.getCanGo("up") && !(exploredSet.contains(ourMaze[(int) up]) ) && !priorityQueue.contains(ourMaze[(int) up])&& up>=0){
                priorityQueue.add(ourMaze[(int) up] );
            }long down = position + 8;
            if (currentNode.getCanGo("down") && !(exploredSet.contains(ourMaze[(int) down]) ) && !priorityQueue.contains(ourMaze[(int) down])&&down<=63){
                priorityQueue.add(ourMaze[(int) down]);
            }long right = position + 1;
            if (currentNode.getCanGo("right") && !(exploredSet.contains(ourMaze[(int) right]) ) && !priorityQueue.contains(ourMaze[(int) right]) && right<=63){
                priorityQueue.add(ourMaze[(int) right]);
            }long left = position - 1;
            if (currentNode.getCanGo("left") && !(exploredSet.contains(ourMaze[(int) left]) )&& !priorityQueue.contains(ourMaze[(int) left]) &&left>=0){
                priorityQueue.add(ourMaze[(int) left]);
            }

        }
        return exploredSet;
    }

}
