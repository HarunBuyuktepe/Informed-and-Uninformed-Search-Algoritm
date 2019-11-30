import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonSimpleWriteExample {

    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("position", 0);
        obj.put("isVisited", false);

        obj.put("condition",LabyrinthNodes.Condition.Normal );
        JSONArray way = new JSONArray();
        way.add(true);
        way.add(true);
        way.add(true);
        way.add(true);

        obj.put("way", way);

        try (FileWriter file = new FileWriter("package.json")) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}