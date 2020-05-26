package Data;

import Tetris.Tetris;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

/**
 * This class will write to .json file.
 * <code>data</code> Store the data here.
 */
public class WriteToJSON {
    public static JSONArray data = new JSONArray();

    /**
     * The <code>records</code> method put the score, and the destroyed lines number (from Tetris class), two jsonobject, and add it to data
     * jsonarray, and store.
     * Call the <code>myfilewriter()</code> method, this will write to .json file.
     */
    public static void records() {
        String scoreT = Integer.toString(Tetris.score);
        String lineT = Integer.toString(Tetris.linesNo);

        JSONObject scores = new JSONObject();
        scores.put("Player", "ReadyPlayerOne");
        scores.put("scores", scoreT);
        scores.put("levels", lineT);

        JSONObject tableObject = new JSONObject();
        tableObject.put("Action", scores);

        data.add(tableObject);

        myfilewriter();



    }

    /**
     * This method point to "table.json" fill, we will put the <code>data</code> jsonarray into.
     */
    public static void myfilewriter() {

        try (FileWriter file = new FileWriter("table.json")) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will clear the old .json file.
     */
    public static void deleteF(){

        data = new JSONArray();

    }
}
