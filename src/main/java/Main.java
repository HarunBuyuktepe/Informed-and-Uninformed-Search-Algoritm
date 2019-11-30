import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static int costUCS;
    public static int costDFS;
    public static int costBFS;
    public static int costIDS;
    public static int costAstar;
    public static int costGreedy;
    public static void main(String[] args) {
        System.out.println("Harun Baba");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();

        System.out.println("\nDFS Explored Set");
        DFS dfs = new DFS();
        ArrayList<LabyrinthNodes> ExploredSetDFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator = ExploredSetDFS.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + costDFS);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("\nBFS Explored Set");
        BFS bfs = new BFS();
        ArrayList<LabyrinthNodes> ExploredSetBFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator1 = ExploredSetDFS.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + costBFS);
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }

        System.out.println("\nIDS Explored Set");
        IDS ids = new IDS();
        ArrayList<LabyrinthNodes> ExploredSetIDS = ids.applyIDS(maze,17);
        Iterator<LabyrinthNodes> iterator2 = ExploredSetIDS.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + costIDS);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }

        System.out.println("\nIDS Explored Set");
        UCS ucs = new UCS();
        ArrayList<LabyrinthNodes> ExploredSetUCS = ucs.applyUCS(maze,17);
        Iterator<LabyrinthNodes> iterator3 = ExploredSetUCS.iterator();
        System.out.println("Cost of Uniform Cost Search" + " " + costUCS);
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next().toString());
        }
    }
}
