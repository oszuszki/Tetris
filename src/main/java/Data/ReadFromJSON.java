package Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.tinylog.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromJSON {

    public static JSONArray myreadlist;
    public static ArrayList<String> scores;
    public static ArrayList<String> player;
    public static ArrayList<String> lines;


    @SuppressWarnings("unchecked")
    public static void read(){
        scores = new ArrayList<>();
        player = new ArrayList<>();
        lines = new ArrayList<>();


        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("table.json"))
        {
            Object obj = parser.parse(reader);

            myreadlist = (JSONArray) obj;
            myreadlist.forEach( emp -> listParting((JSONObject)emp) );
        }
        catch (ParseException | IOException e){
            e.printStackTrace();
        }
    }

    public static void listParting(JSONObject actions)
    {
        JSONObject listObject = (JSONObject) actions.get("Action");

        String name = (String) listObject.get("Player");
        player.add(name);

        String score = (String) listObject.get("scores");
        scores.add(score);

        String line = (String) listObject.get("levels");
        lines.add(line);
        Logger.debug("Stored data: Name: {}, Score: {}, Line: {}.", name , score, line);

    }

}

