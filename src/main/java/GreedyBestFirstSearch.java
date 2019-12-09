import java.util.*;

public class GreedyBestFirstSearch {
    int cost=0;
    GreedyBestFirstSearch(){}
    ArrayList<LabyrinthNodes> expandedSet = new ArrayList<>();
    ArrayList<LabyrinthNodes> exploredSet = new ArrayList<>();
    public Result applyGreedyBestFirstSearch(Maze maze, int startNode,ArrayList<Long> goals){
        calcHvalue(maze,goals,startNode);

        LabyrinthNodes[] ourMaze = maze.getMaze();
        LabyrinthNodes currentNode = ourMaze[startNode];

        PriorityQueue<LabyrinthNodes> priorityQueue = new PriorityQueue<LabyrinthNodes>(64,
                new Comparator<LabyrinthNodes>(){
                    public int compare(LabyrinthNodes i, LabyrinthNodes j){
                        if(i.hScore>j.hScore){
                            return 1;
                        }
                        else if (i.hScore<j.hScore){
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
        currentNode.gScore = 0;
        while (!priorityQueue.isEmpty() && !success){
            currentNode = priorityQueue.poll();
            expandedSet.add(currentNode);

            if (currentNode.getCond().toString().equals("Goal")){
                success = true;exploredSet  = getPath(expandedSet.get(expandedSet.size()-1));
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
                int gtemp=currentNode.gScore+tempCost;
                int ftemp=gtemp+e.hScore;

                if((expandedSet.contains(e)) && (ftemp>= e.fScore)){
                    continue;
                }
                else if((!priorityQueue.contains(e)) || (ftemp < e.fScore)){
                    e.parent = currentNode;
                    e.gScore = gtemp;
                    e.fScore = ftemp;

                    if(priorityQueue.contains(e)){
                        priorityQueue.remove(e);
                    }
                    priorityQueue.add(e);


                }

            }

        }
        exploredSet  = getPath(expandedSet.get(expandedSet.size()-1));
        return new Result(exploredSet,expandedSet,cost);
    }
    public void calcHvalue(Maze maze, ArrayList<Long> goals,int start){

        for(LabyrinthNodes e : maze.getMaze()){
            int y= (int) ((e.position/8)+1);int x = (int) ((e.position%8)+1);
            int min=999;
            for(long l:goals){
                int ly= (int) ((l/8)+1);int lx = (int) ((l%8)+1);
                int temp=Math.abs(ly-y)+Math.abs(lx-x);
                if(min>temp)
                    min=temp;
            }
            e.hScore=min;
        }
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
        GreedyBestFirstSearch a=new GreedyBestFirstSearch();
        System.out.println("Harun Baba");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result expandedSetAstar = a.applyGreedyBestFirstSearch(maze,17,maze.getGoalState());
        System.out.println(expandedSetAstar.cost);
        System.out.println("Cost of A Star" + " " + expandedSetAstar.cost);
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
