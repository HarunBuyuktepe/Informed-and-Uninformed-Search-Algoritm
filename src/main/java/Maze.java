import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze {
    LabyrinthNodes[] maze;
    ArrayList<Long> goalStates;
    Maze(){
        maze = new LabyrinthNodes[64];
    }
    public void buildMaze(){
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("package.json")) {
            goalStates = new ArrayList<Long>();

            JSONArray jsonFile = (JSONArray) parser.parse(reader);
            Iterator<JSONObject> iterator = jsonFile.iterator();
            int j=0;
            while (iterator.hasNext()){
                LabyrinthNodes labyrinthNodes = new LabyrinthNodes();
                JSONObject jsonObject=iterator.next();
                //System.out.println(jsonObject);

                Long position = (Long) jsonObject.get("position");
                labyrinthNodes.setPosition(position);

                String cond = (String) jsonObject.get("condition");
                if(cond.equals("Goal")) {
                    labyrinthNodes.cond=LabyrinthNodes.Condition.Goal;
                    goalStates.add(position);
                }
                else if(cond.equals("Trap"))labyrinthNodes.cond=LabyrinthNodes.Condition.Trap;
                else labyrinthNodes.cond=LabyrinthNodes.Condition.Normal;

                boolean visited = (boolean) jsonObject.get("isVisited");
                labyrinthNodes.setIsVisited(false);

                // loop array
                boolean way[] = new boolean[4];
                JSONArray msg = (JSONArray) jsonObject.get("way");
                Iterator<Boolean> iterator2 = msg.iterator();
                int i=0;
                while (iterator2.hasNext()) {
                    way[i]= (iterator2.next());
                    i++;
                }
                labyrinthNodes.setCanGo(way);
                maze[j]=labyrinthNodes;j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public LabyrinthNodes[] getMaze(){
        return maze;
    }
    public ArrayList<Long> getGoalState(){
        return goalStates;
    }
}
