package Data;

import Tetris.Tetris;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class WriteToJSON {
    public static JSONArray data = new JSONArray();

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

    public static void myfilewriter() {

        try (FileWriter file = new FileWriter("table.json")) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteF(){

        data = new JSONArray();

    }
}
