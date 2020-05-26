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

    /**
     * <code>myreadlist</code> We will add into the read data.
     */
    public static JSONArray myreadlist;
    public static ArrayList<String> scores;
    public static ArrayList<String> player;
    public static ArrayList<String> lines;

    /**
     * <code>@SuppressWarnings("unchecked")</code> Sometimes Java generics just doesn't let you do what you want to,
     * and you need to effectively tell the compiler that what you're doing really will be legal at execution time.
     *
     * This method will read .json file.
     * Create a reader, witch will read the "table.json", then we put the file content, into the <code>obj</code> after
     * we convert to array, and put into <code>myreadlist</code> separately. Separated with the method <code>listParting</code>
     * method.
     */
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

    /**
     * This method will parting the read list to two different arraylist.
     * <code>player</code> The player name.
     * <code>scores</code> The earned score.
     * <code>lines</code> The destroyed lines.
     * @param actions This gets the json object, and the method will parting this.
     */
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

