import java.util.*;

public class UCS {

    UCS(){}
    int cost=0;
    ArrayList<LabyrinthNodes> expandedSet = new ArrayList<>();
    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();
    public Result applyUCS(Maze maze, int startNode){

        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];

        PriorityQueue<LabyrinthNodes> priorityQueue = new PriorityQueue<LabyrinthNodes>(64,
                new Comparator<LabyrinthNodes>(){
                    public int compare(LabyrinthNodes i, LabyrinthNodes j){
                        if(i.fScore>j.fScore){
                            return 1;
                        }
                        else if (i.fScore<j.fScore){
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
            expandedSet.add(currentNode);

            if (currentNode.getCond().toString().equals("Goal")){
                exploredSet  = getPath(expandedSet.get(expandedSet.size()-1));cost++;
                return new Result(exploredSet,expandedSet,cost);
            }

            long position = currentNode.getPosition();
            long left = position - 1;long right = position + 1;
            long up = position - 8;long down = position + 8;


            
            ArrayList<LabyrinthNodes> canGo=new ArrayList<>();
            if (currentNode.getCanGo("right") && !(expandedSet.contains(ourMaze[(int) right]) ) && !priorityQueue.contains(ourMaze[(int) right]) && right<=63){
                canGo.add(ourMaze[(int) right]);
            }if (currentNode.getCanGo("down") && !(expandedSet.contains(ourMaze[(int) down]) ) && !priorityQueue.contains(ourMaze[(int) down])&&down<=63){
                canGo.add(ourMaze[(int) down]);
            }if (currentNode.getCanGo("left") && !(expandedSet.contains(ourMaze[(int) left]) )&& !priorityQueue.contains(ourMaze[(int) left]) &&left>=0){
                canGo.add(ourMaze[(int) left]);
            }if (currentNode.getCanGo("up") && !(expandedSet.contains(ourMaze[(int) up]) ) && !priorityQueue.contains(ourMaze[(int) up])&& up>=0){
                canGo.add(ourMaze[(int) up] );
            }

            for(LabyrinthNodes e : canGo){
                int tempCost= (e.getCond().toString().equals("Trap")) ? 6  : 1;
                e.fScore=tempCost;

                if(!expandedSet.contains(e) && !priorityQueue.contains(e)){
                    e.fScore = currentNode.fScore + tempCost;
                    e.parent = currentNode;
                    priorityQueue.add(e);

                }


                //current path is shorter than previous path found
                else if((priorityQueue.contains(e))&&(e.fScore>(currentNode.fScore+tempCost))){
                    e.parent=currentNode;
                    e.fScore = currentNode.fScore + tempCost;
                    priorityQueue.remove(e);
                    priorityQueue.add(currentNode);

                }

            }

        }
        exploredSet  = getPath(expandedSet.get(expandedSet.size()-1));
        return new Result(exploredSet,expandedSet,cost);
    }
    public ArrayList<LabyrinthNodes> getPath(LabyrinthNodes target){
        ArrayList<LabyrinthNodes> path = new ArrayList<LabyrinthNodes>();

        for(LabyrinthNodes node = target; node!=null; node = node.parent){
            path.add(node);
            if(node.getCond().toString().equals("Trap"))cost+=6;
            else cost++;
        }

        Collections.reverse(path);

        return path;
    }
    public static void main(String[] args){
        UCS ucs1=new UCS();


        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result set =ucs1.applyUCS(maze,17);
        System.out.println(set.cost);
        System.out.println("Cost of UCS" + " " + set.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator7 = set.expandedSet.iterator();
        while (iterator7.hasNext()) {
            System.out.print(iterator7.next().toString()+" \t-->\t ");
            if(iterator7.hasNext())
                System.out.println(iterator7.next().toString());
        }
        System.out.println("ne");
        Iterator<LabyrinthNodes> piterator7 = set.solutionPath.iterator();
        while (piterator7.hasNext()) {
            System.out.print(piterator7.next().toString()+" \t-->\t ");
            if(piterator7.hasNext())
                System.out.println(piterator7.next().toString());
        }


    }

}
