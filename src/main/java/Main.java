import java.util.ArrayList;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {
        System.out.println("Harun Buyuktepe\n150115020\nFirst Project of Artificial Intelligence Course");
        BFS bfs1=new BFS();
        System.out.println("\n\n\n");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();
        Result bfs = bfs1.applyBFS(maze,17);
        System.out.println(bfs.cost);
        System.out.println("Cost of BFS" + " " + bfs.cost);
        System.out.println("Expanded Path");
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

        DFS dfs1=new DFS();
        System.out.println("\n\n\n");

        maze.buildMaze();
        maze.getMaze();
        Result set = dfs1.applyDFS(maze,17);
        System.out.println(set.cost);
        System.out.println("Cost of DFS" + " " + set.cost);
        System.out.println("Expanded Path");
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


        IDS a=new IDS();
        System.out.println("\n\n\n");

        maze.buildMaze();
        maze.getMaze();
        Result expandedSetAstar = a.applyIDS(maze,17);
        System.out.println(expandedSetAstar.cost);
        System.out.println("Cost of IDS" + " " + expandedSetAstar.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator5 = expandedSetAstar.expandedSet.iterator();
        while (iterator5.hasNext()) {
            System.out.print(iterator5.next().toString()+" \t-->\t ");
            if(iterator5.hasNext())
                System.out.println(iterator5.next().toString());
        }
        System.out.println("Solution Path");
        Iterator<LabyrinthNodes> piterator5 = expandedSetAstar.solutionPath.iterator();
        while (piterator5.hasNext()) {
            System.out.print(piterator5.next().toString()+" \t-->\t ");
            if(piterator5.hasNext())
                System.out.println(piterator5.next().toString());
        }

        UCS ucs1=new UCS();
        System.out.println("\n\n\n");

        maze.buildMaze();
        maze.getMaze();
        set =ucs1.applyUCS(maze,17);
        System.out.println(set.cost);
        System.out.println("Cost of UCS" + " " + set.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator7 = set.expandedSet.iterator();
        while (iterator7.hasNext()) {
            System.out.print(iterator7.next().toString()+" \t-->\t ");
            if(iterator7.hasNext())
                System.out.println(iterator7.next().toString());
        }
        System.out.println("\nSolution Path");
        Iterator<LabyrinthNodes> piterator7 = set.solutionPath.iterator();
        while (piterator7.hasNext()) {
            System.out.print(piterator7.next().toString()+" \t-->\t ");
            if(piterator7.hasNext())
                System.out.println(piterator7.next().toString());
        }

        GreedyBestFirstSearch greedyBestFirstSearch=new GreedyBestFirstSearch();
        System.out.println("\n\n\n");

        maze.buildMaze();
        maze.getMaze();
        expandedSetAstar = greedyBestFirstSearch.applyGreedyBestFirstSearch(maze,17,maze.getGoalState());
        System.out.println("Cost of A Star" + " " + expandedSetAstar.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator8 = expandedSetAstar.expandedSet.iterator();
        while (iterator8.hasNext()) {
            System.out.print(iterator8.next().toString()+" \t-->\t ");
            if(iterator8.hasNext())
                System.out.println(iterator8.next().toString());
        }
        System.out.println("\nSolution Path");
        Iterator<LabyrinthNodes> piterator8 = expandedSetAstar.solutionPath.iterator();
        while (piterator8.hasNext()) {
            System.out.print(piterator8.next().toString()+" \t-->\t ");
            if(piterator8.hasNext())
                System.out.println(piterator8.next().toString());
        }

        AStarSearch aStarSearch=new AStarSearch();
        System.out.println("\n\n\n");

        maze.buildMaze();
        maze.getMaze();
        expandedSetAstar = aStarSearch.applyAstar(maze,17,maze.getGoalState());
        System.out.println(expandedSetAstar.cost);
        System.out.println("Cost of A Star" + " " + expandedSetAstar.cost);
        System.out.println("Expanded Path");
        Iterator<LabyrinthNodes> iterator9 = expandedSetAstar.expandedSet.iterator();
        while (iterator9.hasNext()) {
            System.out.print(iterator9.next().toString()+" \t-->\t ");
            if(iterator9.hasNext())
                System.out.println(iterator9.next().toString());
        }
        System.out.println("\nSolution Path");
        Iterator<LabyrinthNodes> piterator9 = expandedSetAstar.solutionPath.iterator();
        while (piterator9.hasNext()) {
            System.out.print(piterator9.next().toString()+" \t-->\t ");
            if(piterator9.hasNext())
                System.out.println(piterator9.next().toString());
        }

    }
}
