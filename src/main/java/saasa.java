import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class saasa {

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("package.json")) {

            JSONArray jsonFile = (JSONArray) parser.parse(reader);
            Iterator<JSONObject> iterator = jsonFile.iterator();
            LabyrinthNodes[] maze = new LabyrinthNodes[64];
            int j=0;
            while (iterator.hasNext()){
                LabyrinthNodes labyrinthNodes = new LabyrinthNodes();
                JSONObject jsonObject=iterator.next();
                //System.out.println(jsonObject);

                String cond = (String) jsonObject.get("condition");
                if(cond.equals(LabyrinthNodes.Condition.Goal)) labyrinthNodes.cond=LabyrinthNodes.Condition.Goal;
                else if(cond.equals(LabyrinthNodes.Condition.Trap))labyrinthNodes.cond=LabyrinthNodes.Condition.Trap;

                Long position = (Long) jsonObject.get("position");
                labyrinthNodes.setPosition((position));

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


}