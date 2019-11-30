import org.json.simple.JSONObject;
import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Harun Baba");

        Maze maze = new Maze();
        maze.buildMaze();
        maze.getMaze();

        System.out.println("\nDFS Explored Set");
        DFS dfs = new DFS();
        ArrayList<LabyrinthNodes> ExploredSetDFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator = ExploredSetDFS.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("\nBFS Explored Set");
        BFS bfs = new BFS();
        ArrayList<LabyrinthNodes> ExploredSetBFS = dfs.applyDFS(maze,17);
        Iterator<LabyrinthNodes> iterator1 = ExploredSetDFS.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().toString());
        }

        System.out.println("\nIDS Explored Set");
        IDS ids = new IDS();
        ArrayList<LabyrinthNodes> ExploredSetIDS = ids.applyIDS(maze,17);
        Iterator<LabyrinthNodes> iterator2 = ExploredSetIDS.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }
    }
}
