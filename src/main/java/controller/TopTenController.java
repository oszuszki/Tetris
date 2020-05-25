package controller;

import Data.TableData;
import Data.ReadFromJSON;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Tetris.Tetris;

import java.net.URL;
import java.util.ResourceBundle;

public class TopTenController implements Initializable{
    public TableView<TableData> toptenTable;

    public TableColumn<TableData,String> player;
    public TableColumn<TableData,String>  level;
    public TableColumn<TableData,String>  score;


    public void initialize(URL location, ResourceBundle resource) {
        player.setCellValueFactory(new PropertyValueFactory<>("DataPlayer"));
        level.setCellValueFactory(new PropertyValueFactory<>("DataScore"));
        score.setCellValueFactory(new PropertyValueFactory<>("DataLevel"));

        toptenTable.setItems(observableList);
    }

    /**ObservableList<TableData> observableList=FXCollections.observableArrayList(
     new TableData(ReadFromJSON.player.get(0), ReadFromJSON.lines.get(0), ReadFromJSON.scores.get(0))
     );*/
    public static ObservableList<TableData> observableList ;

    public static void upload(){

        if (Tetris.score > 1) {
            observableList = FXCollections.observableArrayList(

                    new TableData(ReadFromJSON.player.get(0), ReadFromJSON.lines.get(0), ReadFromJSON.scores.get(0))
            );
        } else {
            observableList = FXCollections.observableArrayList(

                    new TableData("TestDummy", "12", "666") );
        }


    }
}