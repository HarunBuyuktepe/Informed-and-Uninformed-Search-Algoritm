import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static int costUCS;
    public static int costDFS;
    public static int costBFS;
    public static int costAstar;
    public static int costGreedy;
    public static void main(String[] args) {
        System.out.println("Harun Baba");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();

        /*System.out.println("\nDFS Explored Set");
        DFS dfs = new DFS();
        Result ExploredSetDFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator = ExploredSetDFS.exploredSet.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + ExploredSetDFS.cost);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("\nBFS Explored Set");
        BFS bfs = new BFS();
        Result ExploredSetBFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator1 = ExploredSetBFS.exploredSet.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + ExploredSetBFS.cost);
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }

        System.out.println("\nIDS Explored Set");
        IDS ids = new IDS();
        Result ExploredSetIDS = ids.applyIDS(maze,17);
        Iterator<LabyrinthNodes> iterator2 = ExploredSetIDS.expandedSet.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + ExploredSetIDS.cost);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }*/

        System.out.println("\nUCS Explored Set");
        UCS ucs = new UCS();
        Result ExploredSetUCS = ucs.applyUCS(maze,17);
        Iterator<LabyrinthNodes> iterator3 = ExploredSetUCS.exploredSet.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + ExploredSetUCS.cost);
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next().toString());
        }
        Iterator<LabyrinthNodes> piterator3 = ExploredSetUCS.expandedSet.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + ExploredSetUCS.cost);
        while (piterator3.hasNext()) {
            System.out.println(piterator3.next().toString());
        }

    }
}
